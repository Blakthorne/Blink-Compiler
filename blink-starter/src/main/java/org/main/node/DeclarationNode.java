package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public class DeclarationNode extends Node {
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class MethodDeclaration extends DeclarationNode {
        private String identifier;
        private List<ArgumentDeclarationNode> arguments = new ArrayList<>();
        private TypeNode returnType;
        private List<DeclarationNode> members = new ArrayList<>();
        private StatementNode statement;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class VariableDeclaration extends DeclarationNode {
        private String identifier;
        private TypeNode type;
        private StatementNode value;
    }
}
