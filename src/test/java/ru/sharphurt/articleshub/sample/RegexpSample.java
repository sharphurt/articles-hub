package ru.sharphurt.articleshub.sample;

public class RegexpSample {

    public static final String normalStringNoIndent = "Text string without indent";
    public static final String normalStringHeader1 = "#Header 1 Text";
    public static final String normalStringHeader2 = "##Header 2 Text";
    public static final String normalStringHeader3 = "###Header 3 Text";
    public static final String normalStringHeader4 = "####Header 4 Text";
    public static final String normalStringHeader5 = "#####Header 5 Text";
    public static final String normalStringHeader6 = "######Header 6 Text";
    public static final String longPrefixStringHeader6 = "##########Header with 10 '#'. Should be H6";
    public static final String hashesInMiddleOfString = "Text with####hashes in middle of string";
    public static final String hashesInEndOfString = "Text with hashes in end of string#####";
    public static final String startsWithDigitsString = "1234 Text starts with digits";
    public static final String startsWithSymbolsString = "-!_-Text starts with symbols";

    public static final String startsWithSpacesString = "     Text starts with 5 spaces";
}
