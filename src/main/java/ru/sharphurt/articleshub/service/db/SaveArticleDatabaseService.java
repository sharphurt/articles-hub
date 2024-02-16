package ru.sharphurt.articleshub.service.db;

import ru.sharphurt.articleshub.model.ArticleDocument;

public interface SaveArticleDatabaseService {

    String serviceName = "save-article-database-service";

    String save(ArticleDocument document);
}
