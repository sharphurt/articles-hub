package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.GetArticlesListResponseDto;
import ru.sharphurt.articleshub.service.db.GetAllArticlesDatabaseService;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_GET_ARTICLES_LIST_PROCESSED;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_GET_ARTICLES_LIST_RECEIVED;
import static ru.sharphurt.articleshub.mapper.ArticleDocumentMapper.ARTICLE_DOCUMENT_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetArticlesListControllerService {

    private final GetAllArticlesDatabaseService service;

    public GetArticlesListResponseDto call() {
        log.info(LOG_GET_ARTICLES_LIST_RECEIVED);

        var articles = service.getAllArticles().stream().map(ARTICLE_DOCUMENT_MAPPER::entityToInformationDto).toList();
        log.info(LOG_GET_ARTICLES_LIST_PROCESSED);

        return GetArticlesListResponseDto.builder().articles(articles).build();
    }
}
