package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;
import ru.sharphurt.articleshub.model.Node;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class GetArticleResponseDto {

    private String id;
    private String name;
    private List<Node> nodes;
    private Date creationDate;
}
