package ru.sharphurt.articleshub.controller;

import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.sharphurt.articleshub.dto.api.ControllerResponse;
import ru.sharphurt.articleshub.dto.resp.GetArticleResponseDto;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;
import ru.sharphurt.articleshub.repository.ArticleRepository;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.sharphurt.articleshub.sample.MultipartFileSample.*;

public class ArticleControllerTest extends BaseSpringContextTest {

    @Autowired
    private ArticleRepository repository;

    @AfterEach
    @BeforeEach
    public void afterEach() {
        repository.deleteAll();
    }

    @Test
    public void uploadArticle_successTest() throws Exception {
        var filename = FilenameUtils.getBaseName(multipartFile_correct.getOriginalFilename());

        mvc.perform(multipart("/api/upload").file(multipartFile_correct))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andExpect(jsonPath("result").exists())
                .andExpect(jsonPath("result.id").exists())
                .andExpect(jsonPath("result.name").value(filename));
    }

    @Test
    public void getAllArticles_successTest() throws Exception {
        mvc.perform(multipart("/api/upload").file(multipartFile_correct));
        mvc.perform(multipart("/api/upload").file(multipartFile1_correct));
        mvc.perform(multipart("/api/upload").file(multipartFile2_correct));

        mvc.perform(get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andExpect(jsonPath("result.articles", hasSize(3)))
                .andExpect(jsonPath("result.articles[0].name").value("correctfile"))
                .andExpect(jsonPath("result.articles[1].name").value("correctfile1"))
                .andExpect(jsonPath("result.articles[2].name").value("correctfile2"));
    }

    @Test
    public void uploadSameArticle_successTest() throws Exception {
        var response = mvc.perform(multipart("/api/upload")
                        .file(multipartFile_correct))
                .andReturn()
                .getResponse()
                .getContentAsString();

        var id = objectMapper.readValue(response, UploadArticleResponseStructureDto.class).getResult().getId();
        var expectedErrorMessage = "Exception during request execution: save-article-database-service | Same article already uploaded, but can have different name. Found ID's: { %s }";

        mvc.perform(get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andExpect(jsonPath("result.articles", hasSize(1)));

        mvc.perform(multipart("/api/upload").file(multipartFile_correct))
                .andExpect(status().isConflict())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("false"))
                .andExpect(jsonPath("error").value(expectedErrorMessage.formatted(id)));
    }

    @Test
    public void getArticle_successTest() throws Exception {
        var uploadResponse = mvc.perform(multipart("/api/upload")
                        .file(multipartFileRichText_correct))
                .andReturn()
                .getResponse()
                .getContentAsString();

        var id = objectMapper.readValue(uploadResponse, UploadArticleResponseStructureDto.class).getResult().getId();

        mvc.perform(get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andExpect(jsonPath("result.articles", hasSize(1)));

        var getResponse = mvc.perform(get("/api/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andReturn().getResponse().getContentAsString();

        var nodes = objectMapper.readValue(getResponse, GetArticleResponseStructureDto.class).getResult().getNodes();
        assertEquals(normalDocumentAfterUploadExpected, nodes);
    }

    @Test
    public void deleteArticle_successTest() throws Exception {
        var uploadResponse = mvc.perform(multipart("/api/upload")
                        .file(multipartFileRichText_correct))
                .andReturn()
                .getResponse()
                .getContentAsString();

        var id = objectMapper.readValue(uploadResponse, UploadArticleResponseStructureDto.class).getResult().getId();

        mvc.perform(get("/api/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andExpect(jsonPath("result.articles", hasSize(1)));

        mvc.perform(delete("/api/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("successful").value("true"))
                .andExpect(jsonPath("result.success").value("true"));
    }

    private static final class UploadArticleResponseStructureDto extends ControllerResponse<UploadArticleResponseDto> {
    }


    private static final class GetArticleResponseStructureDto extends ControllerResponse<GetArticleResponseDto> {
    }
}

