package ru.sharphurt.articleshub.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.repository.ArticleRepository;

import java.util.List;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_GET_ALL_ARTICLES;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetAllArticlesDatabaseService {

    private final ArticleRepository repository;

    private final String serviceName = "get-all-articles-database-service";

    public List<ArticleDocument> getAllArticles() {
        var articles = repository.findAll();
        log.info(LOG_GET_ALL_ARTICLES.formatted(articles.size()));

        return articles;
    }
}
