package ru.sharphurt.articleshub.service.parsetext;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import ru.sharphurt.articleshub.model.NodeType;
import ru.sharphurt.articleshub.service.parser.ParseDocumentService;
import ru.sharphurt.articleshub.service.util.ParseUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sharphurt.articleshub.sample.RegexpSample.*;

public class RegexpTest {
    @InjectMocks
    public ParseDocumentService service;

    @Test
    @SneakyThrows
    public void normalStringNoIndent_success() {
        var clearString = ParseUtil.getClearString(normalStringNoIndent);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringNoIndent);
        assertEquals("Text string without indent", clearString);
        assertEquals(NodeType.TEXT, nodeType);
    }
    @Test
    @SneakyThrows
    public void normalStringHeader1_success() {
        var clearString = ParseUtil.getClearString(normalStringHeader1);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringHeader1);
        assertEquals("Header 1 Text", clearString);
        assertEquals(NodeType.H1, nodeType);
    }

    @Test
    @SneakyThrows
    public void normalStringHeader2_success() {
        var clearString = ParseUtil.getClearString(normalStringHeader2);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringHeader2);
        assertEquals("Header 2 Text", clearString);
        assertEquals(NodeType.H2, nodeType);
    }

    @Test
    @SneakyThrows
    public void normalStringHeader3_success() {
        var clearString = ParseUtil.getClearString(normalStringHeader3);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringHeader3);
        assertEquals("Header 3 Text", clearString);
        assertEquals(NodeType.H3, nodeType);
    }

    @Test
    @SneakyThrows
    public void normalStringHeader4_success() {
        var clearString = ParseUtil.getClearString(normalStringHeader4);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringHeader4);
        assertEquals("Header 4 Text", clearString);
        assertEquals(NodeType.H4, nodeType);
    }

    @Test
    @SneakyThrows
    public void normalStringHeader5_success() {
        var clearString = ParseUtil.getClearString(normalStringHeader5);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringHeader5);
        assertEquals("Header 5 Text", clearString);
        assertEquals(NodeType.H5, nodeType);
    }

    @Test
    @SneakyThrows
    public void normalStringHeader6_success() {
        var clearString = ParseUtil.getClearString(normalStringHeader6);
        var nodeType = ParseUtil.getNodeTypeFromLine(normalStringHeader6);
        assertEquals("Header 6 Text", clearString);
        assertEquals(NodeType.H6, nodeType);
    }

    @Test
    @SneakyThrows
    public void longPrefixStringHeader6_success() {
        var clearString = ParseUtil.getClearString(longPrefixStringHeader6);
        var nodeType = ParseUtil.getNodeTypeFromLine(longPrefixStringHeader6);
        assertEquals("####Header with 10 '#'. Should be H6", clearString);
        assertEquals(NodeType.H6, nodeType);
    }

    @Test
    @SneakyThrows
    public void hashesInMiddleOfString_success() {
        var clearString = ParseUtil.getClearString(hashesInMiddleOfString);
        var nodeType = ParseUtil.getNodeTypeFromLine(hashesInMiddleOfString);
        assertEquals("Text with####hashes in middle of string", clearString);
        assertEquals(NodeType.TEXT, nodeType);
    }

    @Test
    @SneakyThrows
    public void hashesInEndOfString_success() {
        var clearString = ParseUtil.getClearString(hashesInEndOfString);
        var nodeType = ParseUtil.getNodeTypeFromLine(hashesInEndOfString);
        assertEquals("Text with hashes in end of string#####", clearString);
        assertEquals(NodeType.TEXT, nodeType);
    }
    @Test
    @SneakyThrows
    public void startsWithDigitsString_success() {
        var clearString = ParseUtil.getClearString(startsWithDigitsString);
        var nodeType = ParseUtil.getNodeTypeFromLine(startsWithDigitsString);
        assertEquals("1234 Text starts with digits", clearString);
        assertEquals(NodeType.TEXT, nodeType);
    }
    @Test
    @SneakyThrows
    public void startsWithSymbolsString_success() {
        var clearString = ParseUtil.getClearString(startsWithSymbolsString);
        var nodeType = ParseUtil.getNodeTypeFromLine(startsWithSymbolsString);
        assertEquals("-!_-Text starts with symbols", clearString);
        assertEquals(NodeType.TEXT, nodeType);
    }

    @Test
    @SneakyThrows
    public void startsWithSpacesString_success() {
        var clearString = ParseUtil.getClearString(startsWithSpacesString);
        var nodeType = ParseUtil.getNodeTypeFromLine(startsWithSpacesString);
        assertEquals("     Text starts with 5 spaces", clearString);
        assertEquals(NodeType.TEXT, nodeType);
    }
}
