package ru.sharphurt.articleshub.exceptions;

import lombok.extern.slf4j.Slf4j;

import static ru.sharphurt.articleshub.constants.AliasConstants.EXCEPTION_NO_FILE;

@Slf4j
public class FileNotAttached extends BaseException {

    public FileNotAttached(String methodName) {
        super(EXCEPTION_NO_FILE.formatted(methodName), new Throwable());
    }

    public FileNotAttached(String methodName, Throwable e) {
        super(EXCEPTION_NO_FILE.formatted(methodName), e);
    }
}
