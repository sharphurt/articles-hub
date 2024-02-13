package ru.sharphurt.articleshub.service.parsetext;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sharphurt.articleshub.model.Document;
import ru.sharphurt.articleshub.service.parser.ParseTextService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sharphurt.articleshub.sample.ParseDocumentSample.*;

@ExtendWith(MockitoExtension.class)
public class ParseLinesTest {

    @InjectMocks
    public ParseTextService service;

    @Test
    @SneakyThrows
    public void parseNormalDocument_success() {
        var document = service.parseLines(normalDocument);
        assertEquals(new Document(normalDocument, normalDocumentExpected), document);
    }

    @Test
    @SneakyThrows
    public void parseBigIndentDocument_success() {
        var document = service.parseLines(bigIndentDocument);
        assertEquals(new Document(bigIndentDocument, bigIndentDocumentExpected), document);
    }

    @Test
    @SneakyThrows
    public void parseFullSimpleTextDocument_success() {
        var document = service.parseLines(fullSimpleTextDocument);
        assertEquals(new Document(fullSimpleTextDocument, fullSimpleTextDocumentExpected), document);
    }


    @Test
    @SneakyThrows
    public void parseNotFirstLevelIndentDocument_success() {
        var document = service.parseLines(notFirstLevelIndentDocument);
        assertEquals(new Document(notFirstLevelIndentDocument, notFirstLevelIndentExpected), document);
    }

}
