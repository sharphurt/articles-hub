package ru.sharphurt.articleshub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.api.ControllerSuccessResponse;
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
    public ControllerSuccessResponse<UploadArticleResponseDto> uploadArticle(@RequestParam("file") MultipartFile file) {
        return ControllerSuccessResponse.of(uploadArticleService.call(file));
    }

    @GetMapping("/{id}")
    public ControllerSuccessResponse<GetArticleResponseDto> getArticle(@PathVariable("id") String id) {
        return ControllerSuccessResponse.of(getArticleService.call(id));
    }

    @GetMapping("/all")
    public ControllerSuccessResponse<GetArticlesListResponseDto> getArticlesList() {
        return ControllerSuccessResponse.of(getArticlesListService.call());
    }

    @DeleteMapping("/{id}")
    public ControllerSuccessResponse<DeleteArticleResponseDto> deleteArticle(@PathVariable("id") String id) {
        return ControllerSuccessResponse.of(deleteArticlesListService.call(id));
    }
}
