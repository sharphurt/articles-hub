package ru.sharphurt.articleshub.service.parser;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.model.Document;
import ru.sharphurt.articleshub.model.Node;
import ru.sharphurt.articleshub.model.NodeType;

import javax.print.Doc;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Slf4j
@Service
public class ParseTextService {

    public List<String> convertBytesToLines(byte[] bytes) throws IOException {
        var lines = new ArrayList<String>();

        try (var it = IOUtils.lineIterator(new ByteArrayInputStream(bytes), "UTF-8")) {
            while (it.hasNext()) {
                lines.add(it.nextLine());
            }
        }

        return lines;
    }

    public Document parseLines(List<String> lines) {
        var stack = new Stack<Node>();
        var prevIndent = 0;
        var minIndent = Integer.MAX_VALUE;

        for (var i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            var clearText = getClearString(line);
            var nodeType = getNodeTypeFromString(line);

            if (nodeType.getIndent() >= prevIndent) {
                var node = new Node(i, clearText, nodeType);
                stack.push(node);
            }

            if (nodeType == NodeType.TEXT && nodeType.getIndent() < prevIndent) {
                var node = new Node(i, clearText, NodeType.TEXT);
                stack.peek().addChild(node);
            }

            if (nodeType != NodeType.TEXT && nodeType.getIndent() < prevIndent) {
                collapseChildrenToLevel(stack, nodeType.getIndent());
                var node = new Node(i, clearText, nodeType);
                stack.push(node);
            }

            if (nodeType != NodeType.TEXT && nodeType.getIndent() < minIndent) {
                minIndent = nodeType.getIndent();
            }

            prevIndent = stack.peek().getType().getIndent();
        }

        collapseChildrenToLevel(stack, minIndent);
        return new Document(lines, stack.stream().toList());
    }

    private void collapseChildrenToLevel(Stack<Node> stack, Integer level) {
        while (stack.peek().getType().getIndent() > level) {
            collapseChildren(stack);
        }
    }

    private void collapseChildren(Stack<Node> stack) {
        var childrenIndent = stack.peek().getType().getIndent();
        var children = new ArrayList<Node>();

        while (stack.peek().getType().getIndent() == childrenIndent) {
            var node = stack.pop();
            children.add(node);
        }

        stack.peek().addChildren(children.reversed());
    }

    private NodeType getNodeTypeFromString(String string) {
        var prefix = string.replaceAll("^(#{0,6})(.*)$", "$1");
        return NodeType.typePrefixes.get(prefix);
    }

    private String getClearString(String string) {
        return string.replaceAll("^(#{0,6})(.*)$", "$2");
    }

}
