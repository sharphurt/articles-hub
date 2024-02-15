package ru.sharphurt.articleshub.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.exceptions.ArticleNotFoundException;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.repository.ArticleRepository;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_SEARCH_ARTICLE;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindArticleDatabaseService {

    private final ArticleRepository repository;

    private final String serviceName = "get-article-database-service";

    public ArticleDocument getArticleById(String id) {
        log.info(LOG_SEARCH_ARTICLE.formatted(id));
        return repository.findById(id).orElseThrow(() -> new ArticleNotFoundException(serviceName, id));
    }
}
