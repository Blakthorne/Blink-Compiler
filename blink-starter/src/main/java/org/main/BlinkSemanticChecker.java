package org.main;

import org.main.decl.Decl;
import org.main.decl.Type;
import org.main.node.*;
import org.main.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class BlinkSemanticChecker implements BlinkASTVisitor<Object> {
    private final SymbolTable symbolTable = new SymbolTable();
    private final Stack<Decl> declStack = new Stack<>();

    private boolean isPredeclaredType(String name) {
        return Type.isPredeclaredType(name);
    }

    private boolean isInvalidateAssignment(String operator, Type type1, Type type2) {
        if(!type1.getIsPrimitive()) {
            var clazz1 = symbolTable.lookup(type1.getName(), Decl.ClassDecl.class);
            var clazz2 = symbolTable.lookup(type2.getName(), Decl.ClassDecl.class);
            if(clazz1.isPresent() && clazz2.isPresent()) {
                // check to see if these two types are related (for polymorphism checks)
                var clazz1actual = clazz1.get();
                while(clazz1actual != null) {
                    if(clazz1actual.equals(clazz2.get())) {
                        return false;
                    }
                    clazz1actual = clazz1actual.getParent();
                }
                var clazz2actual = clazz2.get();
                while(clazz2actual != null) {
                    if(clazz2actual.equals(clazz1.get())) {
                        return false;
                    }
                    clazz2actual = clazz2actual.getParent();
                }
                return true;
            }
        }
        // allow non-primitives to have nil assigned to them
        return !type1.equals(type2)
                && (!operator.equals("concat") || !type1.equals(Type.STRING) || !type2.equals(Type.INT))
                && (!operator.equals("concat") || !type2.equals(Type.STRING) || !type1.equals(Type.INT))
                && (!operator.equals("equal") || type1.getIsPrimitive() || !type2.equals(Type.NIL))
                && (!operator.equals("equal") || type2.getIsPrimitive() || !type1.equals(Type.NIL));
    }

    private void validateCalls(Node node, String name, List<Decl.ArgDecl> arguments, List<ExpressionNode> values) {
        if(arguments.size() != values.size()) {
            ErrorReporter.get().reportError(node.getLineNumber(), name + " expects " + arguments.size() + " arguments but received " + values.size(), ErrorReporter.ErrorType.SEMANTIC);
        } else {
            for(int i = 0; i < values.size(); ++i) {
                Type expr = (Type) visit(values.get(i));
                if(isInvalidateAssignment("equal", arguments.get(i).getType(), expr)) {
                    ErrorReporter.get().reportError(node.getLineNumber(), name + " argument " + i + " expects " + arguments.get(i).getType() + " but received " + expr, ErrorReporter.ErrorType.SEMANTIC);
                }
            }
        }
    }

    private Type validateBinaryOperator(Node node, String operator, Type left, Type right, Type[] allowed, Type ret) {
        if(allowed.length > 0 && (!ArrayUtils.arrayContains(allowed, left) || !ArrayUtils.arrayContains(allowed, right))) {
            ErrorReporter.get().reportError(node.getLineNumber(), operator + " operator expects type " + ArrayUtils.join(allowed), ErrorReporter.ErrorType.SEMANTIC);
            return Type.ERROR;
        }
        if(isInvalidateAssignment(operator, left, right)) {
            ErrorReporter.get().reportError(node.getLineNumber(), operator + " operator expects both sides to be compatible", ErrorReporter.ErrorType.SEMANTIC);
            return Type.ERROR;
        }
        return ret;
    }

    private Type validateUnaryOperator(Node node, String operator, Type value, Type[] allowed, Type ret) {
        if(allowed.length > 0 && (!ArrayUtils.arrayContains(allowed, value))) {
            ErrorReporter.get().reportError(node.getLineNumber(), operator + " operator expects type " + ArrayUtils.join(allowed), ErrorReporter.ErrorType.SEMANTIC);
            return Type.ERROR;
        }
        return ret;
    }

    @Override
    public Object visit(StartNode node) {
        for(var i : node.getGlobalMembers()) {
            visit(i);
        }
        return symbolTable;
    }

    @Override
    public Object visit(TypeDeclarationNode node) {
        symbolTable.push();

        // check for redeclaration
        var possible1 = symbolTable.lookup(node.getIdentifier(), Decl.ClassDecl.class);
        if(possible1.isPresent() && possible1.get().getLevel().equals(symbolTable.getCurrentLevel())) {
            ErrorReporter.get().reportError(node.getLineNumber(), "a type of name " + node.getIdentifier() + " already exists", ErrorReporter.ErrorType.SEMANTIC);
        }

        // make a new decl
        Decl.ClassDecl decl = new Decl.ClassDecl(node.getIdentifier(), new Type(node.getIdentifier(), false), symbolTable.getCurrentLevel());
        symbolTable.add(decl);
        declStack.push(decl);

        // handle arguments
        node.getArguments().forEach(this::visit);

        // handle parent
        if(node.getInheritsFrom() != null) {
            var parent = symbolTable.lookup(node.getInheritsFrom(), Decl.ClassDecl.class);
            if(parent.isPresent()) {
                validateCalls(node, node.getInheritsFrom(), parent.get().getArguments(), node.getExpressions());
                decl.setParent(parent.get());
            } else {
                ErrorReporter.get().reportError(node.getLineNumber(), "a type of name " + node.getInheritsFrom() + " does not exist", ErrorReporter.ErrorType.SEMANTIC);
            }
        }

        // handle members
        for(var member : node.getMembers()) {
            if(member instanceof DeclarationNode.VariableDeclaration) {
                decl.getVariables().add((Decl.VarDecl) visit(member));
            } else if (member instanceof DeclarationNode.MethodDeclaration) {
                decl.getMethods().add((Decl.MethodDecl) visit(member));
            }
        }

        declStack.pop();
        symbolTable.pop();
        return decl;
    }

    @Override
    public Object visit(DeclarationNode.MethodDeclaration node) {
        symbolTable.push();

        // check for redeclaration
        var possible1 = symbolTable.lookup(node.getIdentifier(), Decl.MethodDecl.class);
        if(possible1.isPresent() && possible1.get().getLevel() <= symbolTable.getCurrentLevel()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "a method of name " + node.getIdentifier() + " already exists", ErrorReporter.ErrorType.SEMANTIC);
        }

        // make a new decl
        Decl.MethodDecl decl = new Decl.MethodDecl(node.getIdentifier(), Type.VOID, symbolTable.getCurrentLevel());
        if(node.getReturnType() != null) {
            decl.setType((Type) visit(node.getReturnType()));
        }
        symbolTable.add(decl);
        declStack.push(decl);

        // handle arguments
        node.getArguments().forEach(this::visit);

        // handle members
        for(var member : node.getMembers()) {
            if(member instanceof DeclarationNode.VariableDeclaration) {
                decl.getVariables().add((Decl.VarDecl) visit(member));
            } else if (member instanceof DeclarationNode.MethodDeclaration) {
                decl.getMethods().add((Decl.MethodDecl) visit(member));
            }
        }

        Type statement = (Type) visit(node.getStatement());
        if(!Type.VOID.equals(decl.getType())) {
            if(!statement.equals(decl.getType())) {
                ErrorReporter.get().reportError(node.getLineNumber(), "method statement does not match its return type", ErrorReporter.ErrorType.SEMANTIC);
            }
        } else {
            decl.setType(statement);
        }

        declStack.pop();
        symbolTable.pop();
        return decl;
    }

    @Override
    public Object visit(DeclarationNode.VariableDeclaration node) {
        // check to see if this variable already exists
        var possible1 = symbolTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);
        if(possible1.isPresent() && possible1.get().getLevel().equals(symbolTable.getCurrentLevel())) {
            ErrorReporter.get().reportError(node.getLineNumber(), "a variable of name " + node.getIdentifier() + " already exists", ErrorReporter.ErrorType.SEMANTIC);
            return null;
        }
        var possible2 = symbolTable.lookup(node.getIdentifier(), Decl.VarDecl.class);
        if(possible2.isPresent() && possible2.get().getLevel().equals(symbolTable.getCurrentLevel())) {
            ErrorReporter.get().reportError(node.getLineNumber(), "a variable of name " + node.getIdentifier() + " already exists", ErrorReporter.ErrorType.SEMANTIC);
            return null;
        }
        Type type = (Type) visit(node.getValue());
        // it does not so create it
        Decl.VarDecl decl = new Decl.VarDecl(node.getIdentifier(), type, symbolTable.getCurrentLevel());
        if(node.getType() != null) {
            decl.setType((Type) visit(node.getType()));
        }
        // add it to the symbol table for lookups
        if(isInvalidateAssignment("equal", decl.getType(), type)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "variable expected " + decl.getType() + " but got " + type, ErrorReporter.ErrorType.SEMANTIC);
        }
        symbolTable.add(decl);
        return decl;
    }

    @Override
    public Object visit(ArgumentDeclarationNode node) {
        // check to see if this argument already exists
        var possible = symbolTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);
        if(possible.isPresent() && possible.get().getLevel().equals(symbolTable.getCurrentLevel())) {
            ErrorReporter.get().reportError(node.getLineNumber(), "an argument of name " + node.getIdentifier() + " already exists", ErrorReporter.ErrorType.SEMANTIC);
        }
        // grab the current things arguments so we can add the arg decl
        List<Decl.ArgDecl> currentArguments = new ArrayList<>();
        if(declStack.peek() instanceof Decl.ClassDecl) {
            currentArguments = ((Decl.ClassDecl) declStack.peek()).getArguments();
        } else if (declStack.peek() instanceof Decl.MethodDecl) {
            currentArguments = ((Decl.MethodDecl) declStack.peek()).getArguments();
        }
        // build the decl
        Decl.ArgDecl decl = new Decl.ArgDecl(node.getIdentifier(), (Type) visit(node.getType()), symbolTable.getCurrentLevel(), currentArguments.size());
        // add it to the current thing
        if(declStack.peek() instanceof Decl.ClassDecl) {
            ((Decl.ClassDecl) declStack.peek()).getArguments().add(decl);
        } else if (declStack.peek() instanceof Decl.MethodDecl) {
            ((Decl.MethodDecl) declStack.peek()).getArguments().add(decl);
        }
        // add it to the symbol table for lookups
        symbolTable.add(decl);
        return null;
    }

    private void validTypeExpressionsAreInt(List<ExpressionNode> node) {
        if(node != null && !node.isEmpty()) {
            node.forEach(expr -> {
                if(!visit(expr).equals(Type.INT)) {
                    ErrorReporter.get().reportError(expr.getLineNumber(), "index expression must be of type int", ErrorReporter.ErrorType.SEMANTIC);
                }
            });
        }
    }

    @Override
    public Object visit(TypeNode.Int node) {
        validTypeExpressionsAreInt(node.getArrayIndicies());
        return Type.INT.withDimensions(node.getArrayIndicies().size());
    }

    @Override
    public Object visit(TypeNode.Str node) {
        return Type.STRING.withDimensions(node.getArrayIndicies().size());
    }

    @Override
    public Object visit(TypeNode.Bool node) {
        return Type.BOOL.withDimensions(node.getArrayIndicies().size());
    }

    @Override
    public Object visit(TypeNode.Id node) {
        return new Type(node.getIdentifier(), false, node.getArrayIndicies().size());
    }

    @Override
    public Object visit(StatementNode.If node) {
        Type type = (Type) visit(node.getCondition());
        if(!Type.BOOL.equals(type)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "if condition expects type bool", ErrorReporter.ErrorType.SEMANTIC);
        }
        Type truePart = (Type) visit(node.getIfTrue());
        Type falsePart = node.getIfFalse() != null ? (Type) visit(node.getIfFalse()) : truePart;
        if(isInvalidateAssignment("equal", truePart, falsePart)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "if true and false must return same type", ErrorReporter.ErrorType.SEMANTIC);
        }
        return truePart;
    }

    @Override
    public Object visit(StatementNode.Loop node) {
        Type type = (Type) visit(node.getCondition());
        if(!Type.BOOL.equals(type)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "loop condition expects type bool", ErrorReporter.ErrorType.SEMANTIC);
        }
        return visit(node.getIfTrue());
    }

    @Override
    public Object visit(StatementNode.Expression node) {
        return visit(node.getValue());
    }

    @Override
    public Object visit(ArrayInitializationNode.ArrayInitialization node, Type desiredType, Integer dimensions) {
        if(dimensions != 1) {
            ErrorReporter.get().reportError(node.getLineNumber(), "array initialization does not have correct dimensionality", ErrorReporter.ErrorType.SEMANTIC);
        }
        node.getValues().forEach(expr -> {
            Type exprType = (Type) visit(expr);
            if(!exprType.equals(desiredType)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "array initialization expected " + desiredType + " but got " + expr, ErrorReporter.ErrorType.SEMANTIC);
            }
        });
        return null;
    }

    @Override
    public Object visit(ExpressionNode.Or node) {
        return validateBinaryOperator(node, "or", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.BOOL), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.And node) {
        return validateBinaryOperator(node, "and", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.BOOL), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.Greater node) {
        return validateBinaryOperator(node, "greater", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.STRING, Type.INT), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.GreaterEqual node) {
        return validateBinaryOperator(node, "greater equal", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.STRING, Type.INT), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.Less node) {
        return validateBinaryOperator(node, "less", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.STRING, Type.INT), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.LessEqual node) {
        return validateBinaryOperator(node, "less equal", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.STRING, Type.INT), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.Equal node) {
        return validateBinaryOperator(node, "equal", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.Concat node) {
        return validateBinaryOperator(node, "concat", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.STRING, Type.INT), Type.STRING);
    }

    @Override
    public Object visit(ExpressionNode.Add node) {
        return validateBinaryOperator(node, "add", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.INT), Type.INT);
    }

    @Override
    public Object visit(ExpressionNode.Subtract node) {
        return validateBinaryOperator(node, "subtract", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.INT), Type.INT);
    }

    @Override
    public Object visit(ExpressionNode.Multiply node) {
        return validateBinaryOperator(node, "multiply", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.INT), Type.INT);
    }

    @Override
    public Object visit(ExpressionNode.Divide node) {
        return validateBinaryOperator(node, "divide", (Type) visit(node.getLeft()), (Type) visit(node.getRight()), ArrayUtils.of(Type.class, Type.INT), Type.INT);
    }

    @Override
    public Object visit(ExpressionNode.Negate node) {
        return validateUnaryOperator(node, "negate", (Type) visit(node.getValue()), ArrayUtils.of(Type.class, Type.INT), Type.INT);
    }

    @Override
    public Object visit(ExpressionNode.Not node) {
        return validateUnaryOperator(node, "not", (Type) visit(node.getValue()), ArrayUtils.of(Type.class, Type.BOOL), Type.BOOL);
    }

    @Override
    public Object visit(ExpressionNode.Bool node) {
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.Nil node) {
        return Type.NIL;
    }

    @Override
    public Object visit(ExpressionNode.Method node) {
        Optional<Decl.MethodDecl> method = Optional.empty();
        if(node.getPreDot() != null) {
            var clazz = symbolTable.lookup(((Type) visit(node.getPreDot())).getName(), Decl.ClassDecl.class);
            if(clazz.isPresent()) {
                method = clazz.get().lookupMethod(node.getIdentifier());
            }
        } else {
            method = symbolTable.lookup(node.getIdentifier(), Decl.MethodDecl.class);
        }
        if(method.isEmpty()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "method " + node.getIdentifier() + " could not be located", ErrorReporter.ErrorType.SEMANTIC);
            return Type.ERROR;
        }
        validateCalls(node, node.getIdentifier(), method.get().getArguments(), node.getArguments());
        return method.get().getType();
    }

    @Override
    public Object visit(ExpressionNode.Identifier node) {
        // check array indicies
        for(var index : node.getArrayIndicies()) {
            Type type = (Type) visit(index);
            if(!Type.INT.equals(type)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "array index must be type int", ErrorReporter.ErrorType.SEMANTIC);
                return Type.ERROR;
            }
        }
        // try to find variable
        var possible1 = symbolTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);
        if(possible1.isPresent()) {
            return possible1.get().getType().lessDimensions(node.getArrayIndicies().size());
        }
        var possible2 = symbolTable.lookup(node.getIdentifier(), Decl.VarDecl.class);
        if(possible2.isPresent()) {
            return possible2.get().getType().lessDimensions(node.getArrayIndicies().size());
        }
        // nope didn't find it
        ErrorReporter.get().reportError(node.getLineNumber(), "no variable " + node.getIdentifier() + " is declared in this scope", ErrorReporter.ErrorType.SEMANTIC);
        return Type.ERROR;
    }

    @Override
    public Object visit(ExpressionNode.Str node) {
        return Type.STRING;
    }

    @Override
    public Object visit(ExpressionNode.Me node) {
        var currentClass = symbolTable.getCurrentClass();
        if(currentClass.isPresent()) {
            return currentClass.get().getType();
        }
        ErrorReporter.get().reportError(node.getLineNumber(), "me can only be used inside of a type definition", ErrorReporter.ErrorType.SEMANTIC);
        return Type.ERROR;
    }

    @Override
    public Object visit(ExpressionNode.New node) {
        Type expected = (Type) visit(node.getType());
        var parent = symbolTable.lookup(expected.getName(), Decl.ClassDecl.class);
        if(parent.isPresent() && node.getExpressions() != null && node.getExpressions().size() > 0) {
            validateCalls(node, expected.getName(), parent.get().getArguments(), node.getExpressions());
        } else if(!(parent.isPresent() || isPredeclaredType(expected.getName()))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "a type of name " + expected.getName() + " does not exist", ErrorReporter.ErrorType.SEMANTIC);
        }
        if(node.getExpressions().size() > 0 && node.getInitialValues() != null) {
            ErrorReporter.get().reportError(node.getLineNumber(), "constructor cannot be used with array initial values", ErrorReporter.ErrorType.SEMANTIC);
        }
        if(node.getInitialValues() != null) {
            visit(node.getInitialValues(), expected.withDimensions(0), expected.getDimensions());
        }
        return expected;
    }

    @Override
    public Object visit(ExpressionNode.Int node) {
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Assignment node) {
        // check array indicies
        for(var index : node.getArrayIndicies()) {
            Type type = (Type) visit(index);
            if(!Type.INT.equals(type)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "array index must be type int", ErrorReporter.ErrorType.SEMANTIC);
                return Type.ERROR;
            }
        }
        Type value = (Type) visit(node.getValue());
        // try to find variable
        var possible1 = symbolTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);
        if(possible1.isPresent()) {
            if(isInvalidateAssignment("equal", possible1.get().getType().lessDimensions(node.getArrayIndicies().size()), value)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "type of value does not match variable type", ErrorReporter.ErrorType.SEMANTIC);
                return Type.ERROR;
            }
            return possible1.get().getType();
        }
        var possible2 = symbolTable.lookup(node.getIdentifier(), Decl.VarDecl.class);
        if(possible2.isPresent()) {
            if(isInvalidateAssignment("equal", possible2.get().getType().lessDimensions(node.getArrayIndicies().size()), value)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "type of value does not match variable type", ErrorReporter.ErrorType.SEMANTIC);
                return Type.ERROR;
            }
            return possible2.get().getType();
        }
        // nope didn't find it
        ErrorReporter.get().reportError(node.getLineNumber(), "no variable " + node.getIdentifier() + " is declared in this scope", ErrorReporter.ErrorType.SEMANTIC);
        return Type.ERROR;
    }
}
