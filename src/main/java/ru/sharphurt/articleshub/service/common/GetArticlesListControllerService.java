package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.GetArticlesListResponseDto;
import ru.sharphurt.articleshub.service.db.GetAllArticlesDatabaseService;

import static ru.sharphurt.articleshub.mapper.ArticleDocumentMapper.ARTICLE_DOCUMENT_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetArticlesListControllerService {

    private final GetAllArticlesDatabaseService service;

    public GetArticlesListResponseDto call() {
        var articles = service.getAllArticles().stream().map(ARTICLE_DOCUMENT_MAPPER::entityToInformationDto).toList();
        return GetArticlesListResponseDto.builder().articles(articles).build();
    }
}
