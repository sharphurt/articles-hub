package ru.sharphurt.articleshub.service.common;

import ru.sharphurt.articleshub.dto.resp.DeleteArticleResponseDto;

public interface DeleteArticleControllerService {

    String serviceName = "delete-article-controller-service";

    DeleteArticleResponseDto call(String id);
}
