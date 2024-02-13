package ru.sharphurt.articleshub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Document {
    private List<String> rawText;

    List<Node> nodes;
}
