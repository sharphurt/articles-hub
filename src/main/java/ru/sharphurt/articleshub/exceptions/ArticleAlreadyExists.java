package ru.sharphurt.articleshub.exceptions;

import lombok.extern.slf4j.Slf4j;

import static ru.sharphurt.articleshub.constants.AliasConstants.EXCEPTION_ARTICLE_ALREADY_EXISTS;

@Slf4j
public class ArticleAlreadyExists extends BaseException {

    public ArticleAlreadyExists(String methodName, String foundIds) {
        super(EXCEPTION_ARTICLE_ALREADY_EXISTS.formatted(methodName, foundIds), new Throwable());
    }

    public ArticleAlreadyExists(String methodName, String foundIds, Throwable e) {
        super(EXCEPTION_ARTICLE_ALREADY_EXISTS.formatted(methodName, foundIds), e);
    }
}