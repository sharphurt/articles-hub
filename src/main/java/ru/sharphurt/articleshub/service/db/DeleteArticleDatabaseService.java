package ru.sharphurt.articleshub.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.exceptions.ArticleNotFoundException;
import ru.sharphurt.articleshub.repository.ArticleRepository;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_ARTICLE_DELETED;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteArticleDatabaseService {

    private final ArticleRepository repository;

    private final String serviceName = "delete-article-database-service";

    public void deleteArticleById(String id) {
        var entity = repository.findById(id).orElseThrow(() -> new ArticleNotFoundException(serviceName, id));
        repository.delete(entity);

        log.info(LOG_ARTICLE_DELETED.formatted(entity));
    }
}
