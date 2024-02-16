package ru.sharphurt.articleshub.service.common;

import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;

public interface UploadArticleControllerService {

    String serviceName = "upload-article-controller-service";

    UploadArticleResponseDto call(MultipartFile file);
}
