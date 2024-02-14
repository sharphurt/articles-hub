package ru.sharphurt.articleshub.dto.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import ru.sharphurt.articleshub.exceptions.BaseException;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T extends PayloadDto> {

    private Boolean successful;

    private T result;

    private ExceptionDto error;

    public static <T extends PayloadDto> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, result, null);
    }

    public static <T extends PayloadDto> ApiResponse<T> onError(BaseException e, HttpStatus status) {
        return new ApiResponse<>(false, null, new ExceptionDto(e.getMessage(), status));
    }
}
