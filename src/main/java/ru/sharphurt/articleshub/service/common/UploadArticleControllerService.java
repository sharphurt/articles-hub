package ru.sharphurt.articleshub.service.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sharphurt.articleshub.dto.resp.UploadArticleResponseDto;
import ru.sharphurt.articleshub.exceptions.CorruptedFileException;
import ru.sharphurt.articleshub.exceptions.FileNotAttached;
import ru.sharphurt.articleshub.exceptions.UnacceptableFileTypeException;
import ru.sharphurt.articleshub.model.ArticleDocument;
import ru.sharphurt.articleshub.service.db.SaveArticleDatabaseService;
import ru.sharphurt.articleshub.service.parser.ParseDocumentService;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_UPLOAD_ARTICLE_REQUEST_PROCESSED;
import static ru.sharphurt.articleshub.constants.AliasConstants.LOG_UPLOAD_ARTICLE_REQUEST_RECEIVED;

@Slf4j
@Service
@RequiredArgsConstructor
public class UploadArticleControllerService {

    @Value("${app.allowed-extension}")
    private String allowedExtension;

    private final ParseDocumentService parseDocumentService;
    private final SaveArticleDatabaseService saveArticleDatabaseService;
    private final String serviceName = "upload-article-controller-service";

    public UploadArticleResponseDto call(MultipartFile file) {
        var originalName = file.getOriginalFilename();

        if (isNull(originalName) || originalName.isBlank()) {
            throw new FileNotAttached(serviceName);
        }

        log.info(LOG_UPLOAD_ARTICLE_REQUEST_RECEIVED.formatted(originalName));

        var extension = FilenameUtils.getExtension(originalName);
        var filename = FilenameUtils.getBaseName(originalName);
        if (!allowedExtension.equalsIgnoreCase(extension)) {
            throw new UnacceptableFileTypeException(serviceName, originalName);
        }

        List<String> lines;

        try {
            lines = parseDocumentService.convertBytesToLines(file.getBytes());
        } catch (IOException e) {
            throw new CorruptedFileException(serviceName, originalName);
        }

        var nodes = parseDocumentService.parseLines(lines);
        var document = ArticleDocument.builder().name(filename).creationDate(Date.from(Instant.now())).nodes(nodes).build();
        var id = saveArticleDatabaseService.save(document);

        log.info(LOG_UPLOAD_ARTICLE_REQUEST_PROCESSED.formatted(id));

        return UploadArticleResponseDto.builder().id(id).name(filename).build();
    }
}
