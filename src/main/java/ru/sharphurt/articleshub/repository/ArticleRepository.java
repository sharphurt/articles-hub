package ru.sharphurt.articleshub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sharphurt.articleshub.model.ArticleDocument;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends MongoRepository<ArticleDocument, String> {

    @Override
    ArticleDocument save(ArticleDocument entity);

    @Override
    List<ArticleDocument> findAll();

    @Override
    Optional<ArticleDocument> findById(String id);

    @Override
    void deleteById(String id);
}
