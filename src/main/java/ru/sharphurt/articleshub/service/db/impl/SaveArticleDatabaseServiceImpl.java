package ru.sharphurt.articleshub.service.db.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.exceptions.ArticleAlreadyExists;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.repository.ArticleRepository;
import ru.sharphurt.articleshub.service.db.SaveArticleDatabaseService;

import java.util.stream.Collectors;

import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_ARTICLE_SAVED;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_FOUND_DUPLICATIONS;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveArticleDatabaseServiceImpl implements SaveArticleDatabaseService {

    private final ArticleRepository repository;

    public String save(ArticleDocument document) {
        var sameArticles = repository.findByNodes(document.getNodes());

        if (!sameArticles.isEmpty()) {
            var ids = sameArticles.stream().map(ArticleDocument::getId).collect(Collectors.joining(", "));
            log.info(LOG_FOUND_DUPLICATIONS.formatted(ids));
            throw new ArticleAlreadyExists(serviceName, ids);
        }

        var id = repository.save(document).getId();
        log.info(LOG_ARTICLE_SAVED.formatted(id));

        return id;
    }
}
