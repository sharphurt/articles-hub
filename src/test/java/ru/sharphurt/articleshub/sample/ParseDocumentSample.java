package ru.sharphurt.articleshub.sample;

import ru.sharphurt.articleshub.model.Node;
import ru.sharphurt.articleshub.model.NodeType;

import java.util.List;

public class ParseDocumentSample {
    public static List<String> normalDocument = List.of(
            "GREATEST MAN IN ALIVE",
            "#Chapter one",
            "this story about awesome dude that call name is Jack",
            "##Jack's characteristics",
            "###height: 71 inch",
            "###weight: 190 pounds",
            "#Chapter two",
            "Jack was most famous man in alive",
            "his fame was greater than his popularity",
            "##Jack's patents",
            "###mosquito net",
            "###x-ray",
            "###internal combustion engine"
    );

    public static List<Node> normalDocumentExpected = List.of(
            Node.builder().type(NodeType.TEXT).content("GREATEST MAN IN ALIVE").lineNumber(0).build(),
            Node.builder().type(NodeType.H1).content("Chapter one").lineNumber(1).children(List.of(
                    Node.builder().type(NodeType.TEXT).content("this story about awesome dude that call name is Jack").lineNumber(2).build(),
                    Node.builder().type(NodeType.H2).content("Jack's characteristics").lineNumber(3).children(List.of(
                            Node.builder().type(NodeType.H3).content("height: 71 inch").lineNumber(4).build(),
                            Node.builder().type(NodeType.H3).content("weight: 190 pounds").lineNumber(5).build()
                    )).build()
            )).build(),
            Node.builder().type(NodeType.H1).content("Chapter two").lineNumber(6).children(List.of(
                    Node.builder().type(NodeType.TEXT).content("Jack was most famous man in alive").lineNumber(7).build(),
                    Node.builder().type(NodeType.TEXT).content("his fame was greater than his popularity").lineNumber(8).build(),
                    Node.builder().type(NodeType.H2).content("Jack's patents").lineNumber(9).children(List.of(
                            Node.builder().type(NodeType.H3).content("mosquito net").lineNumber(10).build(),
                            Node.builder().type(NodeType.H3).content("x-ray").lineNumber(11).build(),
                            Node.builder().type(NodeType.H3).content("internal combustion engine").lineNumber(12).build()
                    )).build()
            )).build()
    );

    public static List<String> bigIndentDocument = List.of(
            "Big indent sample",
            "#Header 1",
            "##Header 2",
            "###Header 3",
            "####Header 4",
            "#####Header 5",
            "######Header 6",
            "#######Header 7",
            "########Header 8",
            "#########Header 9"
    );

    public static List<Node> bigIndentDocumentExpected = List.of(
            Node.builder().type(NodeType.TEXT).content("Big indent sample").lineNumber(0).build(),
            Node.builder().type(NodeType.H1).content("Header 1").lineNumber(1).children(List.of(
                    Node.builder().type(NodeType.H2).content("Header 2").lineNumber(2).children(List.of(
                            Node.builder().type(NodeType.H3).content("Header 3").lineNumber(3).children(List.of(
                                    Node.builder().type(NodeType.H4).content("Header 4").lineNumber(4).children(List.of(
                                            Node.builder().type(NodeType.H5).content("Header 5").lineNumber(5).children(List.of(
                                                    Node.builder().type(NodeType.H6).content("Header 6").lineNumber(6).build(),
                                                    Node.builder().type(NodeType.H6).content("#Header 7").lineNumber(7).build(),
                                                    Node.builder().type(NodeType.H6).content("##Header 8").lineNumber(8).build(),
                                                    Node.builder().type(NodeType.H6).content("###Header 9").lineNumber(9).build()
                                            )).build()
                                    )).build()
                            )).build()
                    )).build()
            )).build()
    );

    public static List<String> fullSimpleTextDocument = List.of(
            "Full simple text sample",
            "Simple text line #1",
            "Simple text line #2",
            "Simple text line #3",
            "Simple text line #4",
            "Simple text line #5"
    );

    public static List<Node> fullSimpleTextDocumentExpected = List.of(
            Node.builder().type(NodeType.TEXT).content("Full simple text sample").lineNumber(0).build(),
            Node.builder().type(NodeType.TEXT).content("Simple text line #1").lineNumber(1).build(),
            Node.builder().type(NodeType.TEXT).content("Simple text line #2").lineNumber(2).build(),
            Node.builder().type(NodeType.TEXT).content("Simple text line #3").lineNumber(3).build(),
            Node.builder().type(NodeType.TEXT).content("Simple text line #4").lineNumber(4).build(),
            Node.builder().type(NodeType.TEXT).content("Simple text line #5").lineNumber(5).build()
    );

    public static List<String> notFirstLevelIndentDocument = List.of(
            "Not first level indent",
            "####Header 4",
            "Text under header 4 line 1",
            "Text under header 4 line 2",
            "#####Header 5",
            "#####Header 5-1",
            "#####Header 5-2",
            "Text under header 5",
            "#########Header 9"
    );

    public static List<Node> notFirstLevelIndentExpected = List.of(
            Node.builder().type(NodeType.TEXT).content("Not first level indent").lineNumber(0).build(),
            Node.builder().type(NodeType.H4).content("Header 4").lineNumber(1).children(List.of(
                    Node.builder().type(NodeType.TEXT).content("Text under header 4 line 1").lineNumber(2).build(),
                    Node.builder().type(NodeType.TEXT).content("Text under header 4 line 2").lineNumber(3).build(),
                    Node.builder().type(NodeType.H5).content("Header 5").lineNumber(4).build(),
                    Node.builder().type(NodeType.H5).content("Header 5-1").lineNumber(5).build(),
                    Node.builder().type(NodeType.H5).content("Header 5-2").lineNumber(6).children(List.of(
                            Node.builder().type(NodeType.TEXT).content("Text under header 5").lineNumber(7).build(),
                            Node.builder().type(NodeType.H6).content("###Header 9").lineNumber(8).build()
                    )).build()
            )).build()
    );

    public static List<String> withEmptyLinesDocument = List.of(
            "GREATEST MAN IN ALIVE",
            "#Chapter one",
            "",
            "this story about awesome dude that call name is Jack",
            "##Jack's characteristics",
            "###height: 71 inch",
            "###weight: 190 pounds",
            "#Chapter two",
            "Jack was most famous man in alive",
            "his fame was greater than his popularity",
            "",
            "Simple text line #4",
            "##Jack's patents",
            "###mosquito net",
            "",
            "###x-ray",
            "###internal combustion engine"
    );
    public static List<Node> withEmptyLinesDocumentExpected = List.of(
            Node.builder().type(NodeType.TEXT).content("GREATEST MAN IN ALIVE").lineNumber(0).build(),
            Node.builder().type(NodeType.H1).content("Chapter one").lineNumber(1).children(List.of(
                    Node.builder().type(NodeType.TEXT).content("").lineNumber(2).build(),
                    Node.builder().type(NodeType.TEXT).content("this story about awesome dude that call name is Jack").lineNumber(3).build(),
                    Node.builder().type(NodeType.H2).content("Jack's characteristics").lineNumber(4).children(List.of(
                            Node.builder().type(NodeType.H3).content("height: 71 inch").lineNumber(5).build(),
                            Node.builder().type(NodeType.H3).content("weight: 190 pounds").lineNumber(6).build()
                    )).build()
            )).build(),
            Node.builder().type(NodeType.H1).content("Chapter two").lineNumber(7).children(List.of(
                    Node.builder().type(NodeType.TEXT).content("Jack was most famous man in alive").lineNumber(8).build(),
                    Node.builder().type(NodeType.TEXT).content("his fame was greater than his popularity").lineNumber(9).build(),
                    Node.builder().type(NodeType.TEXT).content("").lineNumber(10).build(),
                    Node.builder().type(NodeType.TEXT).content("Simple text line #4").lineNumber(11).build(),
                    Node.builder().type(NodeType.H2).content("Jack's patents").lineNumber(12).children(List.of(
                            Node.builder().type(NodeType.H3).content("mosquito net").lineNumber(13).children(List.of(
                                    Node.builder().type(NodeType.TEXT).content("").lineNumber(14).build()
                            )).build(),
                            Node.builder().type(NodeType.H3).content("x-ray").lineNumber(15).build(),
                            Node.builder().type(NodeType.H3).content("internal combustion engine").lineNumber(16).build()
                    )).build()
            )).build()
    );
}
