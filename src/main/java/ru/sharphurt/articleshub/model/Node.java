package ru.sharphurt.articleshub.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {

    private Integer lineNumber;
    private String content;
    private NodeType type;
    private List<Node> children;

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
