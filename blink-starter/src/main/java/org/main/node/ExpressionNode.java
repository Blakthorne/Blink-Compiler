package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public class ExpressionNode extends Node {
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Or extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class And extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Greater extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class GreaterEqual extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Less extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class LessEqual extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Equal extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Concat extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Add extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Subtract extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Multiply extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Divide extends ExpressionNode {
        private ExpressionNode left;
        private ExpressionNode right;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Negate extends ExpressionNode {
        private ExpressionNode value;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Not extends ExpressionNode {
        private ExpressionNode value;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Int extends ExpressionNode {
        private BigDecimal value;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Bool extends ExpressionNode {
        private Boolean value;
    }

    @EqualsAndHashCode(callSuper = true)
    public static class Nil extends ExpressionNode {
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Method extends ExpressionNode {
        private ExpressionNode preDot;
        private String identifier;
        private List<ExpressionNode> arguments = new ArrayList<>();
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Identifier extends ExpressionNode {
        private String identifier;
        private List<ExpressionNode> arrayIndicies = new ArrayList<>();
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Str extends ExpressionNode {
        private String value;
    }

    @EqualsAndHashCode(callSuper = true)
    public static class Me extends ExpressionNode {
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class New extends ExpressionNode {
        private TypeNode type;
        private List<ExpressionNode> expressions = new ArrayList<>();
        private ArrayInitializationNode initialValues;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Assignment extends ExpressionNode {
        private String identifier;
        private List<ExpressionNode> arrayIndicies = new ArrayList<>();
        private ExpressionNode value;
    }
}
