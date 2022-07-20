package org.main.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StartNode extends Node {
    private List<Node> globalMembers = new ArrayList<>();
}
