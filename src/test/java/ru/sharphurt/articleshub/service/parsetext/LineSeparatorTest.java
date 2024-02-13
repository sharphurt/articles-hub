package ru.sharphurt.articleshub.service.parsetext;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sharphurt.articleshub.service.parser.ParseTextService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sharphurt.articleshub.sample.LineSeparatorsSample.*;

@ExtendWith(MockitoExtension.class)
public class LineSeparatorTest {

    @InjectMocks
    public ParseTextService service;

    @Test
    @SneakyThrows
    public void parseCRLFLines_success() {
        var lines = service.convertBytesToLines(crlfContent.getBytes());
        assertEquals(linesContent, lines);
    }

    @Test
    @SneakyThrows
    public void parseCRLines_success() {
        var lines = service.convertBytesToLines(crContent.getBytes());
        assertEquals(linesContent, lines);
    }

    @Test
    @SneakyThrows
    public void parseLNLines_success() {
        var lines = service.convertBytesToLines(lnContent.getBytes());
        assertEquals(linesContent, lines);
    }

    @Test
    @SneakyThrows
    public void parseMixedLines_success() {
        var lines = service.convertBytesToLines(mixedContent.getBytes());
        assertEquals(linesContent, lines);
    }
}
