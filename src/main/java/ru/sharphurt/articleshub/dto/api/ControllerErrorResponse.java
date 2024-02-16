package ru.sharphurt.articleshub.dto.api;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.sharphurt.articleshub.exceptions.BaseException;

@EqualsAndHashCode(callSuper = true)
public class ControllerErrorResponse extends ResponseEntity<ControllerResponse<?>> {

    private ControllerErrorResponse(Throwable e, HttpStatus status) {
        super(ControllerResponse.builder().successful(false).error(e.getMessage()).result(null).build(), status);
    }

    public static ControllerErrorResponse of(BaseException e, HttpStatus status) {
        return new ControllerErrorResponse(e, status);
    }

    public static ControllerErrorResponse of(RuntimeException e, HttpStatus status) {
        return new ControllerErrorResponse(e, status);
    }
}
