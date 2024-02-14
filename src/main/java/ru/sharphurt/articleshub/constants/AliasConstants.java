package ru.sharphurt.articleshub.constants;

public class AliasConstants {
    public static final String EXCEPTION_MESSAGE_BASE = "Exception during request execution: %s | ";
    public static final String EXCEPTION_CORRUPTED_FILE = EXCEPTION_MESSAGE_BASE + "File { %s } corrupted or empty";
    public static final String EXCEPTION_ARTICLE_NOT_FOUND = EXCEPTION_MESSAGE_BASE + "Article { %s } was not found";
    public static final String EXCEPTION_UNACCEPTABLE_TYPE = EXCEPTION_MESSAGE_BASE + "File { %s } has unaccaptable extension";
}
