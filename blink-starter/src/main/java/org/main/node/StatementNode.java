package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class StatementNode extends Node {
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class If extends StatementNode {
        private ExpressionNode condition;
        private StatementNode ifTrue;
        private StatementNode ifFalse;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Loop extends StatementNode {
        private ExpressionNode condition;
        private StatementNode ifTrue;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Expression extends StatementNode {
        private ExpressionNode value;
    }
}
