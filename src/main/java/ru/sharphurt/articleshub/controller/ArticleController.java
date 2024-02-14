package ru.sharphurt.articleshub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.service.common.GetArticleControllerService;
import ru.sharphurt.articleshub.service.common.UploadArticleControllerService;

@RestController("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final UploadArticleControllerService uploadArticleService;
    private final GetArticleControllerService getArticleService;

    @PostMapping("/upload")
    public ResponseEntity<UploadArticleResponseDto> uploadArticle(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(uploadArticleService.call(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDocument> getArticle(@PathVariable("id") String id) {
        return ResponseEntity.ok(getArticleService.call(id));
    }
}
