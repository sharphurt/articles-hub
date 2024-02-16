package ru.sharphurt.articleshub.service.parsetext;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sharphurt.articleshub.service.parser.impl.ParseDocumentServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sharphurt.articleshub.sample.LineSeparatorsSample.*;

@ExtendWith(MockitoExtension.class)
public class LineSeparatorTest {

    @InjectMocks
    public ParseDocumentServiceImpl service;

    @Test
    @SneakyThrows
    public void parseCRLFLines_success() {
        var lines = service.convertToLines(crlfContent.getBytes(), "test");
        assertEquals(linesContent, lines);
    }

    @Test
    @SneakyThrows
    public void parseCRLines_success() {
        var lines = service.convertToLines(crContent.getBytes(), "test");
        assertEquals(linesContent, lines);
    }

    @Test
    @SneakyThrows
    public void parseLNLines_success() {
        var lines = service.convertToLines(lnContent.getBytes(), "test");
        assertEquals(linesContent, lines);
    }

    @Test
    @SneakyThrows
    public void parseMixedLines_success() {
        var lines = service.convertToLines(mixedContent.getBytes(), "test");
        assertEquals(linesContent, lines);
    }
}
