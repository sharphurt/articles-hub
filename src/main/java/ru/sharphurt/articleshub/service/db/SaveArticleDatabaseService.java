package ru.sharphurt.articleshub.service.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.repository.ArticleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveArticleDatabaseService {

    private final ArticleRepository repository;

    public String save(ArticleDocument document) {
        return repository.save(document).getId();
    }
}
