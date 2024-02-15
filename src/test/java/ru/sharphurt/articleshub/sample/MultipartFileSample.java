package ru.sharphurt.articleshub.sample;

import org.springframework.mock.web.MockMultipartFile;
import ru.sharphurt.articleshub.model.Node;
import ru.sharphurt.articleshub.model.NodeType;

import java.util.List;

public class MultipartFileSample {

    public static String articleText1 = "Artcile 1 text test";
    public static String articleText2 = "Artcile 2 text test";
    public static String articleText3 = "Artcile 3 text test";

    public static String richText = String.join("\n", List.of(
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
    ));

    public static List<Node> normalDocumentAfterUploadExpected = List.of(
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

    public static final MockMultipartFile multipartFile_correct = new MockMultipartFile("file", "correctfile.txt", "multipart/form-data", articleText1.getBytes());
    public static final MockMultipartFile multipartFile1_correct = new MockMultipartFile("file", "correctfile1.txt", "multipart/form-data", articleText2.getBytes());
    public static final MockMultipartFile multipartFile2_correct = new MockMultipartFile("file", "correctfile2.txt", "multipart/form-data", articleText3.getBytes());
    public static final MockMultipartFile multipartFileRichText_correct = new MockMultipartFile("file", "richtext.txt", "multipart/form-data", richText.getBytes());
}
