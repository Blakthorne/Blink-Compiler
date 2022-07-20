package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ArgumentDeclarationNode extends Node {
    private String identifier;
    private TypeNode type;
}
