package ru.sharphurt.articleshub.dto.api;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@EqualsAndHashCode(callSuper = true)
public class ControllerSuccessResponse<T> extends ResponseEntity<ControllerResponse<T>> {

    private ControllerSuccessResponse(T result) {
        super(ControllerResponse.<T>builder().successful(true).error(null).result(result).build(), HttpStatus.OK);
    }

    public static <T> ControllerSuccessResponse<T> of(T result) {
        return new ControllerSuccessResponse<>(result);
    }
}
