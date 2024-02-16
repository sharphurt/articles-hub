package ru.sharphurt.articleshub.service.db;

public interface DeleteArticleDatabaseService {

    String serviceName = "delete-article-database-service";

    void deleteArticleById(String id);
}
