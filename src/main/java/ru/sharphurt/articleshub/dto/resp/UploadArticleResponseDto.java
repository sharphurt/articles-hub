package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UploadArticleResponseDto {

    private UUID id;
}
