package ru.sharphurt.articleshub.service.parsetext;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sharphurt.articleshub.service.parser.ParseDocumentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sharphurt.articleshub.sample.ParseDocumentSample.*;

@ExtendWith(MockitoExtension.class)
public class ParseLinesTest {

    @InjectMocks
    public ParseDocumentService service;

    @Test
    @SneakyThrows
    public void parseNormalDocument_success() {
        var document = service.parseLines(normalDocument);
        assertEquals(normalDocumentExpected, document);
    }

    @Test
    @SneakyThrows
    public void parseBigIndentDocument_success() {
        var document = service.parseLines(bigIndentDocument);
        assertEquals(bigIndentDocumentExpected, document);
    }

    @Test
    @SneakyThrows
    public void parseFullSimpleTextDocument_success() {
        var document = service.parseLines(fullSimpleTextDocument);
        assertEquals(fullSimpleTextDocumentExpected, document);
    }


    @Test
    @SneakyThrows
    public void parseNotFirstLevelIndentDocument_success() {
        var document = service.parseLines(notFirstLevelIndentDocument);
        assertEquals(notFirstLevelIndentExpected, document);
    }

    @Test
    @SneakyThrows
    public void parseWithEmptyLinesDocument_success() {
        var document = service.parseLines(withEmptyLinesDocument);
        assertEquals(withEmptyLinesDocumentExpected, document);
    }

}
