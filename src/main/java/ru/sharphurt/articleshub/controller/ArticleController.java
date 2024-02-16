package ru.sharphurt.articleshub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.api.ControllerSuccessResponse;
import ru.sharphurt.articleshub.dto.resp.DeleteArticleResponseDto;
import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;
import ru.sharphurt.articleshub.dto.resp.GetArticlesListResponseDto;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;
import ru.sharphurt.articleshub.service.common.impl.DeleteArticleControllerServiceImpl;
import ru.sharphurt.articleshub.service.common.impl.GetArticleControllerServiceImpl;
import ru.sharphurt.articleshub.service.common.impl.GetArticlesListControllerServiceImpl;
import ru.sharphurt.articleshub.service.common.impl.UploadArticleControllerServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ArticleController {

    private final UploadArticleControllerServiceImpl uploadArticleService;
    private final GetArticleControllerServiceImpl getArticleService;
    private final GetArticlesListControllerServiceImpl getArticlesListService;
    private final DeleteArticleControllerServiceImpl deleteArticlesListService;

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
