package ru.sharphurt.articleshub.service.parser;

import ru.sharphurt.articleshub.model.Node;

import java.util.List;

public interface ParseDocumentService {

    String serviceName = "parse-document-service";

    List<String> convertToLines(byte[] bytes, String filename);

    List<Node> parseLines(List<String> lines);
}
