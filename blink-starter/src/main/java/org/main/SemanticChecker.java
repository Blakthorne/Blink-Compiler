package org.main;

import org.main.decl.Decl;
import org.main.decl.Type;
import org.main.node.*;

import java.util.concurrent.atomic.AtomicInteger;

public class SemanticChecker implements BlinkASTVisitor<Object> {

    SymbolTable symTable = new SymbolTable();

    @Override
    public Object visit(StartNode node) {
        node.getGlobalMembers().forEach(this::visit);
        return symTable;
    }

    @Override
    public Object visit(TypeDeclarationNode node) {
        symTable.push();

        var classDecl = symTable.lookup(node.getIdentifier(), Decl.ClassDecl.class);

        if (classDecl.isPresent()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Class was previously declared", ErrorReporter.ErrorType.SEMANTIC);
        }

        var decl = new Decl.ClassDecl(node.getIdentifier(), new Type(node.getIdentifier(), false), symTable.getCurrentLevel());
        symTable.add(decl);
        AtomicInteger val = new AtomicInteger(0);
        node.getArguments().forEach( i -> {
            var iRet = (Decl.ArgDecl) visit(i);
            iRet.setPosition(val.getAndIncrement());
            decl.getArguments().add(iRet);
        });
        node.getMembers().forEach( i -> {
            if (i instanceof DeclarationNode.VariableDeclaration) {
                decl.getVariables().add( (Decl.VarDecl) visit(i));
            }
            else if (i instanceof DeclarationNode.MethodDeclaration) {
                decl.getMethods().add( (Decl.MethodDecl) visit(i));
            }
        });

        symTable.pop();
        return decl;
    }

    @Override
    public Object visit(DeclarationNode.MethodDeclaration node) {
        symTable.push();
        var methDecl = symTable.lookup(node.getIdentifier(), Decl.MethodDecl.class);

        if (methDecl.isPresent()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Method was previously declared", ErrorReporter.ErrorType.SEMANTIC);
        }
        Type val2 = Type.VOID;
        if (node.getReturnType() != null) {
            val2 = (Type) visit(node.getReturnType());
        }
        var decl = new Decl.MethodDecl(node.getIdentifier(),val2, symTable.getCurrentLevel());
        symTable.add(decl);

        AtomicInteger val = new AtomicInteger(0);
        node.getArguments().forEach( i -> {
            var iRet = (Decl.ArgDecl) visit(i);
            iRet.setPosition(val.getAndIncrement());
            decl.getArguments().add(iRet);
        });
        node.getMembers().forEach( i -> {
            if (i instanceof DeclarationNode.VariableDeclaration) {
                decl.getVariables().add( (Decl.VarDecl) visit(i));
            }
            else if (i instanceof DeclarationNode.MethodDeclaration) {
                decl.getMethods().add( (Decl.MethodDecl) visit(i));
            }
        });
        Type stat = (Type) visit(node.getStatement());
        if (node.getReturnType() != null) {
            if (!stat.equals(val2)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "Method types do not match", ErrorReporter.ErrorType.SEMANTIC);
            }
        }

        decl.setType(stat);

        symTable.pop();
        return decl;
    }

    @Override
    public Object visit(DeclarationNode.VariableDeclaration node) {
        var varDecl = symTable.lookup(node.getIdentifier(), Decl.VarDecl.class);
        var argDecl = symTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);

        if (varDecl.isPresent()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Variable was previously declared", ErrorReporter.ErrorType.SEMANTIC);
        }

        if (argDecl.isPresent()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Argument was previously declared", ErrorReporter.ErrorType.SEMANTIC);
        }

        Type val = (Type) visit(node.getValue());

        var decl = new Decl.VarDecl(node.getIdentifier(), val, symTable.getCurrentLevel());
        symTable.add(decl);

        if (node.getType() != null) {
            Type val2 = (Type) visit(node.getType());
            if (!val.equals(val2)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "Conflicting variable types", ErrorReporter.ErrorType.SEMANTIC);
            }
        }
        return decl;
    }

    @Override
    public Object visit(ArgumentDeclarationNode node) {
        var argDecl = symTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);

        if (argDecl.isPresent()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Argument was previously declared", ErrorReporter.ErrorType.SEMANTIC);
        }

        Type val = (Type) visit(node.getType());
        var decl = new Decl.ArgDecl(node.getIdentifier(), val, symTable.getCurrentLevel(), 0);

        symTable.add(decl);

        return decl;
    }

    @Override
    public Object visit(TypeNode.Int node) {
        node.getArrayIndicies().forEach(i -> {
           if (i != null) {
               Type iType = (Type) visit(i);
               if (!Type.INT.equals(iType)) {
                   ErrorReporter.get().reportError(node.getLineNumber(), "Int indices must be of type int", ErrorReporter.ErrorType.SEMANTIC);
               }
           }
        });
        return Type.INT.withDimensions(node.getArrayIndicies().size());
    }

    @Override
    public Object visit(TypeNode.Str node) {
        node.getArrayIndicies().forEach(i -> {
            if (i != null) {
                Type iType = (Type) visit(i);
                if (!Type.INT.equals(iType)) {
                    ErrorReporter.get().reportError(node.getLineNumber(), "String indices must be of type int", ErrorReporter.ErrorType.SEMANTIC);
                }
            }
        });
        return Type.STRING.withDimensions(node.getArrayIndicies().size());
    }

    @Override
    public Object visit(TypeNode.Bool node) {
        node.getArrayIndicies().forEach(i -> {
            if (i != null) {
                Type iType = (Type) visit(i);
                if (!Type.INT.equals(iType)) {
                    ErrorReporter.get().reportError(node.getLineNumber(), "Bool indices must be of type int", ErrorReporter.ErrorType.SEMANTIC);
                }
            }
        });
        return Type.BOOL.withDimensions(node.getArrayIndicies().size());
    }

    @Override
    public Object visit(TypeNode.Id node) {
        node.getArrayIndicies().forEach(i -> {
            if (i != null) {
                Type iType = (Type) visit(i);
                if (!Type.INT.equals(iType)) {
                    ErrorReporter.get().reportError(node.getLineNumber(), "Id indices must be of type int", ErrorReporter.ErrorType.SEMANTIC);
                }
            }
        });

        var classRet = symTable.lookup(node.getIdentifier(), Decl.ClassDecl.class);

        if (classRet.isEmpty()) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Id was not used in a class context", ErrorReporter.ErrorType.SEMANTIC);
        }

        return new Type(node.getIdentifier(), false, node.getArrayIndicies().size());
    }

    @Override
    public Object visit(StatementNode.If node) {
        Type ifVar = (Type) visit(node.getCondition());
        if (!Type.BOOL.equals(ifVar)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "If must contain a boolean condition", ErrorReporter.ErrorType.SEMANTIC);
        }

        Type ifTrue = (Type) visit(node.getIfTrue());

        if (node.getIfFalse() != null) {
            Type ifFalse = (Type) visit(node.getIfFalse());
            if (!ifTrue.equals(ifFalse)) {
                ErrorReporter.get().reportError(node.getLineNumber(), "Else must contain a boolean condition", ErrorReporter.ErrorType.SEMANTIC);
            }
        }

        return ifTrue;
    }

    @Override
    public Object visit(StatementNode.Loop node) {
        Type loopVar = (Type) visit(node.getCondition());
        if (!Type.BOOL.equals(loopVar)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Loop must contain a boolean condition", ErrorReporter.ErrorType.SEMANTIC);
        }

        Type ifTrue = (Type) visit(node.getIfTrue());

        return ifTrue;
    }

    @Override
    public Object visit(StatementNode.Expression node) {
        return visit(node.getValue());
    }

    // EC
    @Override
    public Object visit(ArrayInitializationNode.ArrayInitialization node, Type desiredType, Integer dimensions) {
        return null;
    }

    @Override
    public Object visit(ExpressionNode.Or node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide = (Type) visit(node.getRight());
        if (!(Type.BOOL.equals(leftSide)) || !(Type.BOOL.equals(rightSide))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both left and right in the or expression must be of type bool", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.And node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide = (Type) visit(node.getRight());
        if (!(Type.BOOL.equals(leftSide)) || !(Type.BOOL.equals(rightSide))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both left and right in the and expression must be of type bool", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.Greater node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide = (Type) visit(node.getRight());
        if (!(((Type.INT.equals(leftSide)) && (Type.INT.equals(rightSide))) ||
                ((Type.STRING.equals(leftSide)) && (Type.STRING.equals(rightSide))))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both sides in greater must be of the same type, either string or int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.GreaterEqual node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide= (Type) visit(node.getRight());
        if (!(((Type.INT.equals(leftSide)) && (Type.INT.equals(rightSide))) ||
                ((Type.STRING.equals(leftSide)) && (Type.STRING.equals(rightSide))))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both sides in greater than or equal must be of the same type, either string or int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.Less node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide= (Type) visit(node.getRight());
        if (!(((Type.INT.equals(leftSide)) && (Type.INT.equals(rightSide))) ||
                ((Type.STRING.equals(leftSide)) && (Type.STRING.equals(rightSide))))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both sides in greater than must be of the same type, either string or int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.LessEqual node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide= (Type) visit(node.getRight());
        if (!(((Type.INT.equals(leftSide)) && (Type.INT.equals(rightSide))) ||
                ((Type.STRING.equals(leftSide)) && (Type.STRING.equals(rightSide))))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both sides in less than or equal must be of the same type, either string or int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.Equal node) {
        Type leftSide = (Type) visit(node.getLeft());
        Type rightSide= (Type) visit(node.getRight());
        if (leftSide.getIsPrimitive() && rightSide.getIsPrimitive()) {
            if (!(((Type.INT.equals(leftSide)) && (Type.INT.equals(rightSide))) ||
                    ((Type.STRING.equals(leftSide)) && (Type.STRING.equals(rightSide))))) {
                ErrorReporter.get().reportError(node.getLineNumber(), "Both sides in greater than or equal must be of the same type, either string or int", ErrorReporter.ErrorType.SEMANTIC);
            }
        }

        return Type.BOOL;
    }

    @Override
    public Object visit(ExpressionNode.Concat node) {
        Type leftConcat = (Type) visit(node.getLeft());
        Type rightConcat = (Type) visit(node.getRight());
        if (!(Type.STRING.equals(leftConcat)) && !(Type.STRING.equals(rightConcat))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "At least one side in the concat expression must be of type string", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.STRING;
    }

    @Override
    public Object visit(ExpressionNode.Add node) {
        Type leftAdd = (Type) visit(node.getLeft());
        Type rightAdd = (Type) visit(node.getRight());
        if (!(Type.INT.equals(leftAdd)) || !(Type.INT.equals(rightAdd))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both left and right in the add expression must be of type int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Subtract node) {
        Type leftSub = (Type) visit(node.getLeft());
        Type rightSub = (Type) visit(node.getRight());
        if (!(Type.INT.equals(leftSub)) || !(Type.INT.equals(rightSub))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both left and right in the subtract expression must be of type int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Multiply node) {
        Type leftMul = (Type) visit(node.getLeft());
        Type rightMul = (Type) visit(node.getRight());
        if (!(Type.INT.equals(leftMul)) || !(Type.INT.equals(rightMul))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both left and right in the multiply expression must be of type int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Divide node) {
        Type leftDiv = (Type) visit(node.getLeft());
        Type rightDiv = (Type) visit(node.getRight());
        if (!(Type.INT.equals(leftDiv)) || !(Type.INT.equals(rightDiv))) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Both left and right in the divide expression must be of type int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Negate node) {
        Type negateVar = (Type) visit(node.getValue());
        if (!Type.INT.equals(negateVar)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Negate expression should be int", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Not node) {
        Type notVar = (Type) visit(node.getValue());
        if (!Type.BOOL.equals(notVar)) {
            ErrorReporter.get().reportError(node.getLineNumber(), "Not expression should be bool", ErrorReporter.ErrorType.SEMANTIC);
        }
        return Type.BOOL;
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
        var methRet = symTable.lookup(node.getIdentifier(), Decl.MethodDecl.class);

        if (methRet.isPresent()) {
            if (methRet.get().getArguments().size() != node.getArguments().size()) {
                ErrorReporter.get().reportError(node.getLineNumber(), "There is an incorrect number of arguments", ErrorReporter.ErrorType.SEMANTIC);
            }
            else {
                for (int i = 0; i < node.getArguments().size(); ++i) {
                    Type arg = (Type) visit(node.getArguments().get(i));
                    if (!methRet.get().getArguments().get(i).getType().equals(arg)) {
                        ErrorReporter.get().reportError(node.getLineNumber(), "Argument types are not compatible", ErrorReporter.ErrorType.SEMANTIC);
                    }
                }
            }

            return methRet.get().getType();
        }

        ErrorReporter.get().reportError(node.getLineNumber(), "Method does not exist", ErrorReporter.ErrorType.SEMANTIC);

        return Type.ERROR;
    }

    @Override
    public Object visit(ExpressionNode.Identifier node) {
        var argRet = symTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);
        var varRet = symTable.lookup(node.getIdentifier(), Decl.VarDecl.class);

        if (argRet.isPresent() || varRet.isPresent()) {
            if (argRet.isPresent()) {
                return argRet.get().getType();
            }
            else {
                return varRet.get().getType();
            }
        }

        ErrorReporter.get().reportError(node.getLineNumber(), "Identifier does not exist", ErrorReporter.ErrorType.SEMANTIC);

        return Type.ERROR;
    }

    @Override
    public Object visit(ExpressionNode.Str node) {
        return Type.STRING;
    }

    @Override
    public Object visit(ExpressionNode.Me node) {
        var curClass = symTable.getCurrentClass();

        if (curClass.isPresent()) {
            return curClass.get().getType();
        }

        ErrorReporter.get().reportError(node.getLineNumber(), "Me must be inside of a class", ErrorReporter.ErrorType.SEMANTIC);

        return Type.ERROR;
    }

    @Override
    public Object visit(ExpressionNode.New node) {
        Type val = (Type) visit(node.getType());
        var newRet = symTable.lookup(val.getName(), Decl.ClassDecl.class);

        if (newRet.isPresent()) {
            if (newRet.get().getArguments().size() != node.getExpressions().size()) {
                ErrorReporter.get().reportError(node.getLineNumber(), "There is an incorrect number of arguments", ErrorReporter.ErrorType.SEMANTIC);
            }
            else {
                for (int i = 0; i < node.getExpressions().size(); ++i) {
                    Type arg = (Type) visit(node.getExpressions().get(i));
                    if (!newRet.get().getArguments().get(i).getType().equals(arg)) {
                        ErrorReporter.get().reportError(node.getLineNumber(), "Argument types are not compatible", ErrorReporter.ErrorType.SEMANTIC);
                    }
                }
            }
            return val;
        }

        ErrorReporter.get().reportError(node.getLineNumber(), "The expression from new does not exist", ErrorReporter.ErrorType.SEMANTIC);

        return Type.ERROR;
    }

    @Override
    public Object visit(ExpressionNode.Int node) {
        return Type.INT;
    }

    @Override
    public Object visit(ExpressionNode.Assignment node) {
        Type val = (Type) visit(node.getValue());
        var argRet = symTable.lookup(node.getIdentifier(), Decl.ArgDecl.class);
        var varRet = symTable.lookup(node.getIdentifier(), Decl.VarDecl.class);

        if (argRet.isPresent() || varRet.isPresent()) {
            if (argRet.isPresent()) {
                if (!argRet.get().getType().equals(val)) {
                    ErrorReporter.get().reportError(node.getLineNumber(), "Type given was not expected", ErrorReporter.ErrorType.SEMANTIC);
                }
                return argRet.get().getType();
            }
            else {
                if (!varRet.get().getType().equals(val)) {
                    ErrorReporter.get().reportError(node.getLineNumber(), "Type given was not expected", ErrorReporter.ErrorType.SEMANTIC);
                }
                return varRet.get().getType();
            }
        }

        ErrorReporter.get().reportError(node.getLineNumber(), "Assignment does not exist", ErrorReporter.ErrorType.SEMANTIC);

        return Type.ERROR;
    }
}
