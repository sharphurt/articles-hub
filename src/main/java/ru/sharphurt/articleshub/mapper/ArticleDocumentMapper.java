package ru.sharphurt.articleshub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.sharphurt.articleshub.dto.ArticleInformationDto;
import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;
import ru.sharphurt.articleshub.model.ArticleDocument;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleDocumentMapper {

    ArticleDocumentMapper ARTICLE_DOCUMENT_MAPPER = Mappers.getMapper(ArticleDocumentMapper.class);
    ArticleInformationDto entityToInformationDto(ArticleDocument document);
    @Mapping(source = "name", target = "name")
    GetArticleResponseDto entityToResponseDto(ArticleDocument document);
}
