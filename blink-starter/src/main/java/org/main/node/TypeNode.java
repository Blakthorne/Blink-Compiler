package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TypeNode extends Node {
    private List<ExpressionNode> arrayIndicies = new ArrayList<>();

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Int extends TypeNode {
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Str extends TypeNode {
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Bool extends TypeNode {
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Id extends TypeNode {
        public String identifier;
    }
}
