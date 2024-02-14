package ru.sharphurt.articleshub.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.repository.ArticleRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetAllArticlesDatabaseService {

    private final ArticleRepository repository;

    private final String serviceName = "get-all-articles-database-service";

    public List<ArticleDocument> getAllArticles() {
        return repository.findAll();
    }
}
