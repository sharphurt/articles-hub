package ru.sharphurt.articleshub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonIgnore
    //todo: посмотреть, нужно ли
    private List<String> rawText;

    private List<Node> nodes;
}
