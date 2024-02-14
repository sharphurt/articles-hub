package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;
import ru.sharphurt.articleshub.service.db.FindArticleDatabaseService;

import static ru.sharphurt.articleshub.mapper.ArticleDocumentMapper.ARTICLE_DOCUMENT_MAPPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetArticleControllerService {

    private final FindArticleDatabaseService findArticleDatabaseService;

    public GetArticleResponseDto call(String id) {
        var entity = findArticleDatabaseService.getArticleById(id);
        return ARTICLE_DOCUMENT_MAPPER.entityToResponseDto(entity);
    }
}
