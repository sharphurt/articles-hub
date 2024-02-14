package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadArticleResponseDto {

    private String name;
    private String id;
}
