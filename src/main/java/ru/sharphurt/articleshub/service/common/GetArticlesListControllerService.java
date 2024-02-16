package ru.sharphurt.articleshub.service.common;

import ru.sharphurt.articleshub.dto.resp.GetArticlesListResponseDto;

public interface GetArticlesListControllerService {

    String serviceName = "get-articles-controller-service";

    GetArticlesListResponseDto call();
}
