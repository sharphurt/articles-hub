package ru.sharphurt.articleshub.service.util;

import ru.sharphurt.articleshub.model.NodeType;

public class ParseUtil {

    public static NodeType getNodeTypeFromLine(String string) {
        var prefix = string.replaceAll("^(#{0,6})(.*)$", "$1");
        return NodeType.typePrefixes.get(prefix);
    }

    public static String getClearString(String string) {
        return string.replaceAll("^(#{0,6})(.*)$", "$2");
    }
}
