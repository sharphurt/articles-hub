package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sharphurt.articleshub.dto.resp.DeleteArticleResponseDto;
import ru.sharphurt.articleshub.service.db.DeleteArticleDatabaseService;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteArticleControllerService {

    private final DeleteArticleDatabaseService service;

    public DeleteArticleResponseDto call(String id) {
        service.deleteArticleById(id);
        return DeleteArticleResponseDto.builder().success(true).build();
    }
}
