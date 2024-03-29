package ru.sharphurt.articleshub.service.common.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;
import ru.sharphurt.articleshub.service.common.GetArticleControllerService;
import ru.sharphurt.articleshub.service.db.impl.GetArticleDatabaseServiceImpl;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_GET_ARTICLE_PROCESSED;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_GET_ARTICLE_RECEIVED;
import static ru.sharphurt.articleshub.mapper.ArticleDocumentMapper.ARTICLE_DOCUMENT_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetArticleControllerServiceImpl implements GetArticleControllerService {

    private final GetArticleDatabaseServiceImpl service;

    public GetArticleResponseDto call(String id) {
        log.info(LOG_GET_ARTICLE_RECEIVED.formatted(id));

        var result = ARTICLE_DOCUMENT_MAPPER.entityToResponseDto(service.getArticleById(id));
        log.info(LOG_GET_ARTICLE_PROCESSED.formatted(result));

        return result;
    }
}
