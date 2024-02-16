package ru.sharphurt.articleshub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.api.ControllerResponse;
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
    @Operation(summary = "Upload an article on server", description = "Upload a txt file of article on server. The response is ID of article", tags = {"article-hub", "upload"})
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = UploadArticleResponseDto.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "400", description = "File not attached, has unacceptable extension or corrupted", content = {@Content(schema = @Schema(implementation = ControllerResponse.class), mediaType = "application/json")})
    public ControllerSuccessResponse<UploadArticleResponseDto> uploadArticle(@RequestParam("file") MultipartFile file) {
        return ControllerSuccessResponse.of(uploadArticleService.call(file));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an article", description = "Retreive an information about article: upload date, name and paragraphs structure", tags = {"article-hub", "get"})
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = GetArticleResponseDto.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", description = "Article with specified id not found", content = {@Content(schema = @Schema(implementation = ControllerResponse.class), mediaType = "application/json")})
    public ControllerSuccessResponse<GetArticleResponseDto> getArticle(@PathVariable("id") String id) {
        return ControllerSuccessResponse.of(getArticleService.call(id));
    }

    @GetMapping("/all")
    @Operation(summary = "Get articles list", description = "Returns list with all articles on server", tags = {"article-hub", "get-all"})
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = GetArticlesListResponseDto.class), mediaType = "application/json")})
    public ControllerSuccessResponse<GetArticlesListResponseDto> getArticlesList() {
        return ControllerSuccessResponse.of(getArticlesListService.call());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete article", description = "Delete article from server", tags = {"article-hub", "delete"})
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = DeleteArticleResponseDto.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "404", description = "Article with specified id not found", content = {@Content(schema = @Schema(implementation = ControllerResponse.class), mediaType = "application/json")})
    public ControllerSuccessResponse<DeleteArticleResponseDto> deleteArticle(@PathVariable("id") String id) {
        return ControllerSuccessResponse.of(deleteArticlesListService.call(id));
    }
}
