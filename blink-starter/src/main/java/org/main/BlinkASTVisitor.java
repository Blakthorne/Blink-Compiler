package org.main;

import org.main.decl.Type;
import org.main.node.*;

public interface BlinkASTVisitor<T> {
    default T visit(Node node) {
        if(node instanceof ArgumentDeclarationNode) {
            return visit((ArgumentDeclarationNode) node);
        } else if(node instanceof ArrayInitializationNode) {
            return visit((ArrayInitializationNode) node);
        } else if(node instanceof DeclarationNode) {
            return visit((DeclarationNode) node);
        } else if(node instanceof ExpressionNode) {
            return visit((ExpressionNode) node);
        } else if(node instanceof StartNode) {
            return visit((StartNode) node);
        } else if(node instanceof StatementNode) {
            return visit((StatementNode) node);
        } else if(node instanceof TypeDeclarationNode) {
            return visit((TypeDeclarationNode) node);
        } else if(node instanceof TypeNode) {
            return visit((TypeNode) node);
        }
        return null;
    }

    T visit(StartNode node);

    T visit(TypeDeclarationNode node);

    default T visit(DeclarationNode node) {
        if (node instanceof DeclarationNode.MethodDeclaration) {
            return visit((DeclarationNode.MethodDeclaration) node);
        } else if (node instanceof DeclarationNode.VariableDeclaration) {
            return visit((DeclarationNode.VariableDeclaration) node);
        }
        return null;
    }
    T visit(DeclarationNode.MethodDeclaration node);
    T visit(DeclarationNode.VariableDeclaration node);

    T visit(ArgumentDeclarationNode node);

    default T visit(TypeNode node) {
        if (node instanceof TypeNode.Int) {
            return visit((TypeNode.Int) node);
        } else if (node instanceof TypeNode.Str) {
            return visit((TypeNode.Str) node);
        } else if (node instanceof TypeNode.Bool) {
            return visit((TypeNode.Bool) node);
        } else if (node instanceof TypeNode.Id) {
            return visit((TypeNode.Id) node);
        }
        return null;
    }
    T visit(TypeNode.Int node);
    T visit(TypeNode.Str node);
    T visit(TypeNode.Bool node);
    T visit(TypeNode.Id node);

    default T visit(StatementNode node) {
        if (node instanceof StatementNode.If) {
            return visit((StatementNode.If) node);
        } else if (node instanceof StatementNode.Loop) {
            return visit((StatementNode.Loop) node);
        } else if (node instanceof StatementNode.Expression) {
            return visit((StatementNode.Expression) node);
        }
        return null;
    }
    T visit(StatementNode.If node);
    T visit(StatementNode.Loop node);
    T visit(StatementNode.Expression node);

    default T visit(ArrayInitializationNode node, Type desiredType, Integer dimensions) {
        if (node instanceof ArrayInitializationNode.SubArrayInitialization) {
            return visit((ArrayInitializationNode.SubArrayInitialization) node, desiredType, dimensions);
        } else if (node instanceof ArrayInitializationNode.ArrayInitialization) {
            return visit((ArrayInitializationNode.ArrayInitialization) node, desiredType, dimensions);
        }
        return null;
    }
    default T visit(ArrayInitializationNode.SubArrayInitialization node, Type desiredType, Integer dimensions) {
        node.getValues().forEach(x -> {
            x.forEach(y -> {
                visit(y, desiredType, dimensions - 1);
            });
        });
        return null;
    }
    T visit(ArrayInitializationNode.ArrayInitialization node, Type desiredType, Integer dimensions);

    default T visit(ExpressionNode node) {
        if (node instanceof ExpressionNode.Or) {
            return visit((ExpressionNode.Or) node);
        } else if (node instanceof ExpressionNode.And) {
            return visit((ExpressionNode.And) node);
        } else if (node instanceof ExpressionNode.Greater) {
            return visit((ExpressionNode.Greater) node);
        } else if (node instanceof ExpressionNode.GreaterEqual) {
            return visit((ExpressionNode.GreaterEqual) node);
        } else if (node instanceof ExpressionNode.Less) {
            return visit((ExpressionNode.Less) node);
        } else if (node instanceof ExpressionNode.LessEqual) {
            return visit((ExpressionNode.LessEqual) node);
        } else if (node instanceof ExpressionNode.Equal) {
            return visit((ExpressionNode.Equal) node);
        } else if (node instanceof ExpressionNode.Concat) {
            return visit((ExpressionNode.Concat) node);
        } else if (node instanceof ExpressionNode.Add) {
            return visit((ExpressionNode.Add) node);
        } else if (node instanceof ExpressionNode.Subtract) {
            return visit((ExpressionNode.Subtract) node);
        } else if (node instanceof ExpressionNode.Multiply) {
            return visit((ExpressionNode.Multiply) node);
        } else if (node instanceof ExpressionNode.Divide) {
            return visit((ExpressionNode.Divide) node);
        } else if (node instanceof ExpressionNode.Negate) {
            return visit((ExpressionNode.Negate) node);
        } else if (node instanceof ExpressionNode.Not) {
            return visit((ExpressionNode.Not) node);
        } else if (node instanceof ExpressionNode.Bool) {
            return visit((ExpressionNode.Bool) node);
        } else if (node instanceof ExpressionNode.Nil) {
            return visit((ExpressionNode.Nil) node);
        } else if (node instanceof ExpressionNode.Method) {
            return visit((ExpressionNode.Method) node);
        } else if (node instanceof ExpressionNode.Identifier) {
            return visit((ExpressionNode.Identifier) node);
        } else if (node instanceof ExpressionNode.Str) {
            return visit((ExpressionNode.Str) node);
        } else if (node instanceof ExpressionNode.Me) {
            return visit((ExpressionNode.Me) node);
        } else if (node instanceof ExpressionNode.New) {
            return visit((ExpressionNode.New) node);
        } else if (node instanceof ExpressionNode.Int) {
            return visit((ExpressionNode.Int) node);
        } else if (node instanceof ExpressionNode.Assignment) {
            return visit((ExpressionNode.Assignment) node);
        }
        return null;
    }
    T visit(ExpressionNode.Or node);
    T visit(ExpressionNode.And node);
    T visit(ExpressionNode.Greater node);
    T visit(ExpressionNode.GreaterEqual node);
    T visit(ExpressionNode.Less node);
    T visit(ExpressionNode.LessEqual node);
    T visit(ExpressionNode.Equal node);
    T visit(ExpressionNode.Concat node);
    T visit(ExpressionNode.Add node);
    T visit(ExpressionNode.Subtract node);
    T visit(ExpressionNode.Multiply node);
    T visit(ExpressionNode.Divide node);
    T visit(ExpressionNode.Negate node);
    T visit(ExpressionNode.Not node);
    T visit(ExpressionNode.Bool node);
    T visit(ExpressionNode.Nil node);
    T visit(ExpressionNode.Method node);
    T visit(ExpressionNode.Identifier node);
    T visit(ExpressionNode.Str node);
    T visit(ExpressionNode.Me node);
    T visit(ExpressionNode.New node);
    T visit(ExpressionNode.Int node);
    T visit(ExpressionNode.Assignment node);
}
