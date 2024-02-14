package ru.sharphurt.articleshub.exceptions;

import static ru.sharphurt.articleshub.constants.AliasConstants.EXCEPTION_ARTICLE_NOT_FOUND;

public class ArticleNotFoundException extends BaseException {

    public ArticleNotFoundException(String methodName, String uuid) {
        super(EXCEPTION_ARTICLE_NOT_FOUND.formatted(methodName, uuid), new Throwable());
    }

    public ArticleNotFoundException(String methodName, String uuid, Throwable e) {
        super(EXCEPTION_ARTICLE_NOT_FOUND.formatted(methodName, uuid), e);
    }
}
