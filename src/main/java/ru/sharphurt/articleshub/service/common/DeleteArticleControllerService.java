package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.DeleteArticleResponseDto;
import ru.sharphurt.articleshub.service.db.DeleteArticleDatabaseService;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_DELETE_ARTICLE_PROCESSED;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_DELETE_ARTICLE_RECEIVED;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteArticleControllerService {

    private final DeleteArticleDatabaseService service;

    public DeleteArticleResponseDto call(String id) {
        log.info(LOG_DELETE_ARTICLE_RECEIVED.formatted(id));

        service.deleteArticleById(id);
        log.info(LOG_DELETE_ARTICLE_PROCESSED);

        return DeleteArticleResponseDto.builder().success(true).build();
    }
}
