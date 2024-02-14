package ru.sharphurt.articleshub.dto.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ExceptionDto {

    private String message;
    private HttpStatus status;
}
