package ru.sharphurt.articleshub.service.common;

import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;

public interface GetArticleControllerService {

    String serviceName = "get-article-controller-service";

    GetArticleResponseDto call(String id);
}
