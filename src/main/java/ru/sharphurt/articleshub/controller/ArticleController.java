package ru.sharphurt.articleshub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.api.ApiResponse;
import ru.sharphurt.articleshub.dto.resp.DeleteArticleResponseDto;
import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;
import ru.sharphurt.articleshub.dto.resp.GetArticlesListResponseDto;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;
import ru.sharphurt.articleshub.service.common.DeleteArticleControllerService;
import ru.sharphurt.articleshub.service.common.GetArticleControllerService;
import ru.sharphurt.articleshub.service.common.GetArticlesListControllerService;
import ru.sharphurt.articleshub.service.common.UploadArticleControllerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArticleController {

    private final UploadArticleControllerService uploadArticleService;
    private final GetArticleControllerService getArticleService;
    private final GetArticlesListControllerService getArticlesListService;
    private final DeleteArticleControllerService deleteArticlesListService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<UploadArticleResponseDto>> uploadArticle(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(ApiResponse.onSuccess(uploadArticleService.call(file)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetArticleResponseDto>> getArticle(@PathVariable("id") String id) {
        return ResponseEntity.ok(ApiResponse.onSuccess(getArticleService.call(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<GetArticlesListResponseDto>> getArticlesList() {
        return ResponseEntity.ok(ApiResponse.onSuccess(getArticlesListService.call()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<DeleteArticleResponseDto>> deleteArticle(@PathVariable("id") String id) {
        return ResponseEntity.ok(ApiResponse.onSuccess(deleteArticlesListService.call(id)));
    }
}
