package ru.sharphurt.articleshub.dto.resp;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.sharphurt.articleshub.dto.api.PayloadDto;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class UploadArticleResponseDto extends PayloadDto {

    private String id;
    private String name;
}
