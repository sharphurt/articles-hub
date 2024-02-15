package ru.sharphurt.articleshub.model;

import lombok.Getter;

import java.util.Map;

@Getter
public enum NodeType {
    TEXT(0, "text"),
    H1(1, "h1"),
    H2(2, "h2"),
    H3(3, "h3"),
    H4(4, "h4"),
    H5(5, "h5"),
    H6(6, "h6");

    private final int indent;
    private final String representation;

    NodeType(Integer indent, String representation) {
        this.indent = indent;
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }

    public static final Map<String, NodeType> typePrefixes = Map.of(
            "", NodeType.TEXT,
            "#", NodeType.H1,
            "##", NodeType.H2,
            "###", NodeType.H3,
            "####", NodeType.H4,
            "#####", NodeType.H5,
            "######", NodeType.H6
    );
}
