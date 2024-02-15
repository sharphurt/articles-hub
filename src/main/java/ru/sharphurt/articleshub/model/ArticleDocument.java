package ru.sharphurt.articleshub.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document
public class ArticleDocument {

    @Id
    private String id;
    private String name;
    private Date creationDate;
    private List<Node> nodes;
}
