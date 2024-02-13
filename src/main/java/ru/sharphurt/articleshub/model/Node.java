package ru.sharphurt.articleshub.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private Integer lineNumber;
    private String content;
    private NodeType type;
    private List<Node> children;

    public static final Node EMPTY_NODE = new Node(0, "-root-", NodeType.ROOT);

    public Node(Integer lineNumber, String content, NodeType nodeType) {
        this.lineNumber = lineNumber;
        this.content = content;
        this.type = nodeType;
    }

    public void addChild(Node child) {
        if (this.children == null)
            this.children = new ArrayList<>();

        this.children.add(child);
    }

    public void addChildren(List<Node> children) {
        if (this.children == null)
            this.children = new ArrayList<>();

        this.children.addAll(children);
    }
}
