package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArrayInitializationNode extends Node {
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class SubArrayInitialization extends ArrayInitializationNode {
        private List<List<ArrayInitializationNode>> values = new ArrayList<>();
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class ArrayInitialization extends ArrayInitializationNode {
        private List<ExpressionNode> values = new ArrayList<>();
    }
}
