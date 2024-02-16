package ru.sharphurt.articleshub.service.db;

import ru.sharphurt.articleshub.model.ArticleDocument;

import java.util.List;

public interface GetAllArticlesDatabaseService {

    String serviceName = "get-all-articles-database-service";

    List<ArticleDocument> getAllArticles();
}
