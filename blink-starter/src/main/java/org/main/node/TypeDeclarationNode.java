package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TypeDeclarationNode extends Node {
    private String identifier;
    private List<ArgumentDeclarationNode> arguments = new ArrayList<>();
    private String inheritsFrom;
    private List<ExpressionNode> expressions = new ArrayList<>();
    private List<DeclarationNode> members = new ArrayList<>();
}
