package ru.sharphurt.articleshub.dto.resp;

import lombok.Data;
import ru.sharphurt.articleshub.model.Node;

import java.util.List;

@Data
public class GetArticleResponseDto {

    private List<Node> nodes;
}
