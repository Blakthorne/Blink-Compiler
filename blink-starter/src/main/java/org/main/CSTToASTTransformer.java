package org.main;

import org.bju.BlinkBaseVisitor;
import org.bju.BlinkParser;
import org.main.node.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSTToASTTransformer extends BlinkBaseVisitor {
    @Override
    protected Object aggregateResult(Object aggregate, Object nextResult) {
        if(aggregate == null) {
            return nextResult;
        } else {
            if(aggregate instanceof List) {
                if(nextResult != null) {
                    ((List<Object>) aggregate).add(nextResult);
                }
                return aggregate;
            } else {
                List<Object> objects = new ArrayList<Object>();
                objects.add(aggregate);
                objects.add(nextResult);
                objects = objects.stream().filter(x -> x != null).collect(Collectors.toList());
                if(objects.size() == 1) {
                    return objects.get(0);
                } else {
                    return objects;
                }
            }
        }
    }

    private <T extends List> T wrapInListIfNecessary(Object o) {
        if(o instanceof List) {
            return (T) o;
        } else {
            var t = new ArrayList<Object>();
            t.add(o);
            return (T) t;
        }
    }

    @Override
    public Object visitStart(BlinkParser.StartContext ctx) {
        StartNode node = new StartNode();
        for(var child : (List<Node>)wrapInListIfNecessary(visitChildren(ctx))) {
            node.getGlobalMembers().add((Node) child);
        }
        return node;
    }

    @Override
    public Object visitBlink_class(BlinkParser.Blink_classContext ctx) {
        TypeDeclarationNode node = new TypeDeclarationNode();
        node.setLineNumber(ctx.id.getLine());
        node.setIdentifier(ctx.id.getText());
        if(ctx.args != null) {
            node.setArguments(wrapInListIfNecessary(visit(ctx.args)));
        }
        if(ctx.parent != null) {
            node.setInheritsFrom(ctx.parent.id.getText());
            if(ctx.parent.args != null) {
                node.setExpressions(wrapInListIfNecessary(visit(ctx.parent.args)));
            }
        }
        for(var member : ctx.members) {
            node.getMembers().add((DeclarationNode) visit(member));
        }
        return node;
    }

    @Override
    public Object visitInherits(BlinkParser.InheritsContext ctx) {
        return ctx.id.getText();
    }

    @Override
    public Object visitVariable(BlinkParser.VariableContext ctx) {
        DeclarationNode.VariableDeclaration node = new DeclarationNode.VariableDeclaration();
        node.setLineNumber(ctx.id.getLine());
        node.setIdentifier(ctx.id.getText());
        if(ctx.typ != null) {
            node.setType((TypeNode) visit(ctx.typ));
        }
        Object obj = visit(ctx.value);
        if(obj instanceof ExpressionNode) {
            StatementNode.Expression statementNode = new StatementNode.Expression();
            statementNode.setValue((ExpressionNode) obj);
            node.setValue(statementNode);
        } else {
            node.setValue((StatementNode) obj);
        }
        return node;
    }

    @Override
    public Object visitMethod(BlinkParser.MethodContext ctx) {
        DeclarationNode.MethodDeclaration node = new DeclarationNode.MethodDeclaration();
        node.setLineNumber(ctx.id.getLine());
        node.setIdentifier(ctx.id.getText());
        if(ctx.args != null) {
            node.setArguments(wrapInListIfNecessary(visit(ctx.args)));
        }
        if(ctx.typ != null) {
            node.setReturnType((TypeNode) visit(ctx.typ));
        }
        for(var member : ctx.members) {
            node.getMembers().add((DeclarationNode) visit(member));
        }
        if(ctx.value != null) {
            Object obj = visit(ctx.value);
            if(obj instanceof ExpressionNode) {
                StatementNode.Expression statementNode = new StatementNode.Expression();
                statementNode.setValue((ExpressionNode) obj);
                node.setStatement(statementNode);
            } else {
                node.setStatement((StatementNode) obj);
            }
        }
        return node;
    }

    @Override
    public Object visitArgument(BlinkParser.ArgumentContext ctx) {
        ArgumentDeclarationNode node = new ArgumentDeclarationNode();
        node.setLineNumber(ctx.id.getLine());
        node.setIdentifier(ctx.id.getText());
        node.setType((TypeNode) visit(ctx.typ));
        return node;
    }

    @Override
    public Object visitType(BlinkParser.TypeContext ctx) {
        TypeNode node = (TypeNode) visit(ctx.typ);
        if(ctx.sizes != null) {
            ctx.sizes.forEach(x -> {
                node.getArrayIndicies().add((ExpressionNode) visit(x));
            });
        }
        return node;
    }

    @Override
    public Object visitInt_type(BlinkParser.Int_typeContext ctx) {
        TypeNode t = new TypeNode.Int();
        t.setLineNumber(ctx.start.getLine());
        return t;
    }

    @Override
    public Object visitString_type(BlinkParser.String_typeContext ctx) {
        TypeNode t = new TypeNode.Str();
        t.setLineNumber(ctx.start.getLine());
        return t;
    }

    @Override
    public Object visitBool_type(BlinkParser.Bool_typeContext ctx) {
        TypeNode t = new TypeNode.Bool();
        t.setLineNumber(ctx.start.getLine());
        return t;
    }

    @Override
    public Object visitCustom_type(BlinkParser.Custom_typeContext ctx) {
        TypeNode.Id node = new TypeNode.Id();
        node.setLineNumber(ctx.id.getLine());
        node.setIdentifier(ctx.id.getText());
        return node;
    }

    @Override
    public Object visitBlink_if(BlinkParser.Blink_ifContext ctx) {
        StatementNode.If node = new StatementNode.If();
        node.setLineNumber(ctx.start.getLine());
        node.setCondition((ExpressionNode) visit(ctx.expr));
        var val = visit(ctx.true_value);
        if(val instanceof StatementNode) {
            node.setIfTrue((StatementNode) val);
        } else {
            StatementNode.Expression expression = new StatementNode.Expression();
            expression.setValue((ExpressionNode) val);
            node.setIfTrue(expression);
        }
        if(ctx.false_value != null) {
            var val2 = visit(ctx.false_value);
            if(val2 instanceof StatementNode) {
                node.setIfFalse((StatementNode) val2);
            } else {
                StatementNode.Expression expression = new StatementNode.Expression();
                expression.setValue((ExpressionNode) val2);
                node.setIfFalse(expression);
            }
        }
        return node;
    }

    @Override
    public Object visitBlink_else(BlinkParser.Blink_elseContext ctx) {
        return visit(ctx.false_value);
    }

    @Override
    public Object visitLoop(BlinkParser.LoopContext ctx) {
        StatementNode.Loop node = new StatementNode.Loop();
        node.setLineNumber(ctx.start.getLine());
        node.setCondition((ExpressionNode) visit(ctx.expr));
        var val = visit(ctx.value);
        if(val instanceof StatementNode) {
            node.setIfTrue((StatementNode) val);
        } else {
            StatementNode.Expression expression = new StatementNode.Expression();
            expression.setValue((ExpressionNode) val);
            node.setIfTrue(expression);
        }
        return node;
    }

    @Override
    public Object visitOr(BlinkParser.OrContext ctx) {
        ExpressionNode.Or node = new ExpressionNode.Or();
        node.setLineNumber(ctx.start.getLine());
        node.setLeft((ExpressionNode) visit(ctx.first));
        node.setRight((ExpressionNode) visit(ctx.rest));
        return node;
    }

    @Override
    public Object visitAnd(BlinkParser.AndContext ctx) {
        ExpressionNode.And node = new ExpressionNode.And();
        node.setLineNumber(ctx.start.getLine());
        node.setLeft((ExpressionNode) visit(ctx.first));
        node.setRight((ExpressionNode) visit(ctx.rest));
        return node;
    }

    @Override
    public Object visitChecks(BlinkParser.ChecksContext ctx) {
        if(ctx.op.getText().equals("=")) {
            ExpressionNode.Equal node = new ExpressionNode.Equal();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        } else if (ctx.op.getText().equals(">")) {
            ExpressionNode.Greater node = new ExpressionNode.Greater();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        } else if (ctx.op.getText().equals(">=")) {
            ExpressionNode.GreaterEqual node = new ExpressionNode.GreaterEqual();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        } else if (ctx.op.getText().equals("<")) {
            ExpressionNode.Less node = new ExpressionNode.Less();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        }  else if (ctx.op.getText().equals("<=")) {
            ExpressionNode.LessEqual node = new ExpressionNode.LessEqual();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        }
        return null;
    }

    @Override
    public Object visitConcat(BlinkParser.ConcatContext ctx) {
        ExpressionNode.Concat node = new ExpressionNode.Concat();
        node.setLineNumber(ctx.start.getLine());
        node.setLeft((ExpressionNode) visit(ctx.first));
        node.setRight((ExpressionNode) visit(ctx.rest));
        return node;
    }

    @Override
    public Object visitAs(BlinkParser.AsContext ctx) {
        if(ctx.op.getText().equals("+")) {
            ExpressionNode.Add node = new ExpressionNode.Add();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        } else if (ctx.op.getText().equals("-")) {
            ExpressionNode.Subtract node = new ExpressionNode.Subtract();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        }
        return null;
    }

    @Override
    public Object visitMd(BlinkParser.MdContext ctx) {
        if(ctx.op.getText().equals("*")) {
            ExpressionNode.Multiply node = new ExpressionNode.Multiply();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        } else if (ctx.op.getText().equals("/")) {
            ExpressionNode.Divide node = new ExpressionNode.Divide();
            node.setLineNumber(ctx.start.getLine());
            node.setLeft((ExpressionNode) visit(ctx.first));
            node.setRight((ExpressionNode) visit(ctx.rest));
            return node;
        }
        return null;
    }

    @Override
    public Object visitNn(BlinkParser.NnContext ctx) {
        if(ctx.op.getText().equals("~")) {
            ExpressionNode.Negate node = new ExpressionNode.Negate();
            node.setLineNumber(ctx.start.getLine());
            node.setValue((ExpressionNode) visit(ctx.expression()));
            return node;
        } else if (ctx.op.getText().equals("!")) {
            ExpressionNode.Not node = new ExpressionNode.Not();
            node.setLineNumber(ctx.start.getLine());
            node.setValue((ExpressionNode) visit(ctx.expression()));
            return node;
        }
        return null;
    }

    @Override
    public Object visitInt(BlinkParser.IntContext ctx) {
        ExpressionNode.Int node = new ExpressionNode.Int();
        node.setLineNumber(ctx.start.getLine());
        node.setValue(BigDecimal.valueOf(Double.parseDouble(ctx.INTEGER_LITERAL().getText())));
        return node;
    }

    @Override
    public Object visitTrue(BlinkParser.TrueContext ctx) {
        ExpressionNode.Bool node = new ExpressionNode.Bool();
        node.setLineNumber(ctx.start.getLine());
        node.setValue(true);
        return node;
    }

    @Override
    public Object visitFalse(BlinkParser.FalseContext ctx) {
        ExpressionNode.Bool node = new ExpressionNode.Bool();
        node.setLineNumber(ctx.start.getLine());
        node.setValue(false);
        return node;
    }

    @Override
    public Object visitNil(BlinkParser.NilContext ctx) {
        ExpressionNode e = new ExpressionNode.Nil();
        e.setLineNumber(ctx.start.getLine());
        return e;
    }

    @Override
    public Object visitId(BlinkParser.IdContext ctx) {
        ExpressionNode.Identifier node = new ExpressionNode.Identifier();
        node.setLineNumber(ctx.start.getLine());
        node.setIdentifier(ctx.id.getText());
        return node;
    }

    @Override
    public Object visitString(BlinkParser.StringContext ctx) {
        ExpressionNode.Str node = new ExpressionNode.Str();
        node.setLineNumber(ctx.start.getLine());
        node.setValue(ctx.STRING_LITERAL().getText());
        return node;
    }

    @Override
    public Object visitMe(BlinkParser.MeContext ctx) {
        ExpressionNode e = new ExpressionNode.Me();
        e.setLineNumber(ctx.start.getLine());
        return e;
    }

    @Override
    public Object visitNew(BlinkParser.NewContext ctx) {
        ExpressionNode.New node = new ExpressionNode.New();
        node.setLineNumber(ctx.start.getLine());
        node.setType((TypeNode) visit(ctx.typ));
        if(ctx.value != null) {
            node.setExpressions(wrapInListIfNecessary(visit(ctx.value)));
        }
        if(ctx.init != null) {
            node.setInitialValues((ArrayInitializationNode) visit(ctx.init));
        }
        return node;
    }

    @Override
    public Object visitExpressioninit(BlinkParser.ExpressioninitContext ctx) {
        ArrayInitializationNode.ArrayInitialization node = new ArrayInitializationNode.ArrayInitialization();
        node.setLineNumber(ctx.start.getLine());
        node.getValues().addAll((List<ExpressionNode>) visit(ctx.expressions()));
        return node;
    }

    @Override
    public Object visitSubexpressioninit(BlinkParser.SubexpressioninitContext ctx) {
        ArrayInitializationNode.SubArrayInitialization node = new ArrayInitializationNode.SubArrayInitialization();
        node.setLineNumber(ctx.start.getLine());
        node.getValues().add(wrapInListIfNecessary(visit(ctx.init)));
        if(ctx.rest != null) {
            ctx.rest.forEach(x -> {
                node.getValues().add(wrapInListIfNecessary(visit(x)));
            });
        }
        return node;
    }

    @Override
    public Object visitArrayassign(BlinkParser.ArrayassignContext ctx) {
        ExpressionNode.Assignment node = new ExpressionNode.Assignment();
        node.setLineNumber(ctx.start.getLine());
        node.setIdentifier(ctx.assignto.getText());
        for(var x : ctx.values) {
            node.getArrayIndicies().add((ExpressionNode) visit(x));
        }
        node.setValue((ExpressionNode) visit(ctx.value));
        return node;
    }

    @Override
    public Object visitFunction2(BlinkParser.Function2Context ctx) {
        ExpressionNode.Method node = new ExpressionNode.Method();
        node.setLineNumber(ctx.start.getLine());
        node.setIdentifier(ctx.id.getText());
        if(ctx.values != null) {
            node.setArguments(wrapInListIfNecessary(visit(ctx.values)));
        }
        return node;
    }

    @Override
    public Object visitFunction1(BlinkParser.Function1Context ctx) {
        ExpressionNode.Method node = new ExpressionNode.Method();
        node.setLineNumber(ctx.start.getLine());
        node.setPreDot((ExpressionNode) visit(ctx.expression()));
        node.setIdentifier(ctx.id.getText());
        if(ctx.values != null) {
            node.setArguments(wrapInListIfNecessary(visit(ctx.values)));
        }
        return node;
    }

    @Override
    public Object visitIdassign(BlinkParser.IdassignContext ctx) {
        ExpressionNode.Assignment node = new ExpressionNode.Assignment();
        node.setLineNumber(ctx.start.getLine());
        node.setIdentifier(ctx.assignto.getText());
        node.setValue((ExpressionNode) visit(ctx.value));
        return node;
    }
}
