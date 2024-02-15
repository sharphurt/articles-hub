package ru.sharphurt.articleshub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.model.Node;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends MongoRepository<ArticleDocument, String> {

    @Override
    <S extends ArticleDocument> S save(S entity);

    @Override
    List<ArticleDocument> findAll();

    @Override
    Optional<ArticleDocument> findById(String id);

    List<ArticleDocument> findByNodes(List<Node> nodes);

    void delete(ArticleDocument entity);
}
