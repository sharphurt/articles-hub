package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;
import ru.sharphurt.articleshub.dto.ArticleInformationDto;

import java.util.List;

@Data
@Builder
public class GetArticlesListResponseDto {

    public List<ArticleInformationDto> articles;
}

