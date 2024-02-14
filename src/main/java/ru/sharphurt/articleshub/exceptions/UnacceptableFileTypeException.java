package ru.sharphurt.articleshub.exceptions;

import static ru.sharphurt.articleshub.constants.AliasConstants.EXCEPTION_UNACCEPTABLE_TYPE;

public class UnacceptableFileTypeException extends BaseException {

    public UnacceptableFileTypeException(String methodName, String filename) {
        super(EXCEPTION_UNACCEPTABLE_TYPE.formatted(methodName, filename), new Throwable());
    }

    public UnacceptableFileTypeException(String methodName, String filename, Throwable e) {
        super(EXCEPTION_UNACCEPTABLE_TYPE.formatted(methodName, filename), e);
    }
}