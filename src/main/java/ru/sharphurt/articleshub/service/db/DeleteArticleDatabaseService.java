package ru.sharphurt.articleshub.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.repository.ArticleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteArticleDatabaseService {

    private final ArticleRepository repository;

    private final String serviceName = "delete-article-database-service";

    public void deleteArticleById(String id) {
        repository.deleteById(id);
    }
}
