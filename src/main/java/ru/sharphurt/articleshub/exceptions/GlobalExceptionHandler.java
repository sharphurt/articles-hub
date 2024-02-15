package ru.sharphurt.articleshub.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sharphurt.articleshub.dto.api.ControllerErrorResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {FileNotAttached.class, CorruptedFileException.class, UnacceptableFileTypeException.class})
    public ControllerErrorResponse badRequestHandler(BaseException e) {
        return ControllerErrorResponse.of(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public ControllerErrorResponse notFoundException(ArticleNotFoundException e) {
        return ControllerErrorResponse.of(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArticleAlreadyExists.class)
    public ControllerErrorResponse conflictException(ArticleAlreadyExists e) {
        return ControllerErrorResponse.of(e, HttpStatus.CONFLICT);
    }
}
