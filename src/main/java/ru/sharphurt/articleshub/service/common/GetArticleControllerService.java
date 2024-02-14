package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.service.db.FindArticleDatabaseService;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetArticleControllerService {

    private final FindArticleDatabaseService findArticleDatabaseService;

    public ArticleDocument call(String id) {
        return findArticleDatabaseService.getArticleById(id);
    }
}
