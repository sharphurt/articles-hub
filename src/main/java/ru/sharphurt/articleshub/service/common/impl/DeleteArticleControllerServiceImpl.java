package ru.sharphurt.articleshub.service.common.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.DeleteArticleResponseDto;
import ru.sharphurt.articleshub.service.common.DeleteArticleControllerService;
import ru.sharphurt.articleshub.service.db.impl.DeleteArticleDatabaseServiceImpl;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_DELETE_ARTICLE_PROCESSED;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_DELETE_ARTICLE_RECEIVED;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteArticleControllerServiceImpl implements DeleteArticleControllerService {

    private final DeleteArticleDatabaseServiceImpl service;

    public DeleteArticleResponseDto call(String id) {
        log.info(LOG_DELETE_ARTICLE_RECEIVED.formatted(id));

        service.deleteArticleById(id);
        log.info(LOG_DELETE_ARTICLE_PROCESSED);

        return DeleteArticleResponseDto.builder().success(true).build();
    }
}
