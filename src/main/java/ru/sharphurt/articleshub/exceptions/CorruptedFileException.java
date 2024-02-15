package ru.sharphurt.articleshub.exceptions;

import lombok.extern.slf4j.Slf4j;

import static ru.sharphurt.articleshub.constants.AliasConstants.EXCEPTION_CORRUPTED_FILE;

@Slf4j
public class CorruptedFileException extends BaseException {

    public CorruptedFileException(String methodName, String filename) {
        super(EXCEPTION_CORRUPTED_FILE.formatted(methodName, filename), new Throwable());
    }

    public CorruptedFileException(String methodName, String filename, Throwable e) {
        super(EXCEPTION_CORRUPTED_FILE.formatted(methodName, filename), e);
    }
}