package ru.sharphurt.articleshub.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ArticleInformationDto {

    private String id;
    private String name;
    private Date creationDate;
}
