package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.sharphurt.articleshub.dto.api.PayloadDto;
import ru.sharphurt.articleshub.model.Node;

import java.util.Date;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GetArticleResponseDto extends PayloadDto {

    private String id;
    private String name;
    private List<Node> nodes;
    private Date creationDate;
}
