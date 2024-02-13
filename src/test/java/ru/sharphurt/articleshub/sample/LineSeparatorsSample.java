package ru.sharphurt.articleshub.sample;

import java.util.List;

public class LineSeparatorsSample {

    public static String crlfContent = "GREATEST MAN IN ALIVE\r\n#Chapter one\r\nthis story about awesome dude that call name is Jack\r\n##Jack's characteristics";
    public static String crContent = "GREATEST MAN IN ALIVE\r#Chapter one\rthis story about awesome dude that call name is Jack\r##Jack's characteristics";
    public static String lnContent = "GREATEST MAN IN ALIVE\n#Chapter one\nthis story about awesome dude that call name is Jack\n##Jack's characteristics";
    public static String mixedContent = "GREATEST MAN IN ALIVE\r\n#Chapter one\rthis story about awesome dude that call name is Jack\n##Jack's characteristics";

    public static List<String> linesContent = List.of(
            "GREATEST MAN IN ALIVE",
            "#Chapter one",
            "this story about awesome dude that call name is Jack",
            "##Jack's characteristics"
    );
}
