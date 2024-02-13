package ru.sharphurt.articleshub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;
import ru.sharphurt.articleshub.service.common.UploadArticleControllerService;

@RestController("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final UploadArticleControllerService uploadArticleService;

    @PostMapping("/upload")
    public ResponseEntity<UploadArticleResponseDto> uploadArticle(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(uploadArticleService.call(file));
    }
}
