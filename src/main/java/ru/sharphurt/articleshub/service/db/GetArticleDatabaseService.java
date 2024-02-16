package ru.sharphurt.articleshub.service.db;

import ru.sharphurt.articleshub.model.ArticleDocument;

public interface GetArticleDatabaseService {

    String serviceName = "get-article-database-service";

    ArticleDocument getArticleById(String id);
}
