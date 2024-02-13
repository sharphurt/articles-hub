package ru.sharphurt.articleshub.service.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;

import java.util.UUID;

@Slf4j
@Service
public class UploadArticleControllerService {

    public UploadArticleResponseDto call(MultipartFile file) {
        log.info(file.getOriginalFilename());
        return UploadArticleResponseDto.builder().id(UUID.randomUUID()).build();
    }
}
