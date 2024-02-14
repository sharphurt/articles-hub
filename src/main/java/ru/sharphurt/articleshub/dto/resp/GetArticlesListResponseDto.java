package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.sharphurt.articleshub.dto.ArticleInformationDto;
import ru.sharphurt.articleshub.dto.api.PayloadDto;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class GetArticlesListResponseDto extends PayloadDto {

    public List<ArticleInformationDto> articles;
}

