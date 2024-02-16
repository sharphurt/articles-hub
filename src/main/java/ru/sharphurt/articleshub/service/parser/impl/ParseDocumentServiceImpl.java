package ru.sharphurt.articleshub.service.parser.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.exceptions.CorruptedFileException;
import ru.sharphurt.articleshub.model.Node;
import ru.sharphurt.articleshub.model.NodeType;
import ru.sharphurt.articleshub.service.parser.ParseDocumentService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static ru.sharphurt.articleshub.service.util.ParseUtil.getClearString;
import static ru.sharphurt.articleshub.service.util.ParseUtil.getNodeTypeFromLine;

@Slf4j
@Service
public class ParseDocumentServiceImpl implements ParseDocumentService {

    public List<String> convertToLines(byte[] bytes, String filename) {
        var lines = new ArrayList<String>();

        try (var it = IOUtils.lineIterator(new ByteArrayInputStream(bytes), "UTF-8")) {
            while (it.hasNext()) {
                lines.add(it.nextLine());
            }
        } catch (IOException e) {
            throw new CorruptedFileException(serviceName, filename);
        }

        return lines;
    }

    public List<Node> parseLines(List<String> lines) {
        var stack = new Stack<Node>();
        var previousIndent = 0;
        var minIndent = Integer.MAX_VALUE;

        for (var i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            var content = getClearString(line);
            var nodeType = getNodeTypeFromLine(line);
            var node = Node.builder().lineNumber(i).content(content).type(nodeType).build();

            if (nodeType.getIndent() >= previousIndent) {
                stack.push(node);
            }

            if (nodeType == NodeType.TEXT && nodeType.getIndent() < previousIndent) {
                stack.peek().addChild(node);
            }

            if (nodeType != NodeType.TEXT && nodeType.getIndent() < previousIndent) {
                collapseChildrenToLevel(stack, nodeType.getIndent());
                stack.push(node);
            }

            if (nodeType != NodeType.TEXT && nodeType.getIndent() < minIndent) {
                minIndent = nodeType.getIndent();
            }

            previousIndent = stack.peek().getType().getIndent();
        }

        collapseChildrenToLevel(stack, minIndent);
        return stack.stream().toList();
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
}
