package ru.sharphurt.articleshub.constants;

public class AliasConstants {


    public static final String EXCEPTION_MESSAGE_BASE = "Exception during request execution: %s | ";
    public static final String EXCEPTION_CORRUPTED_FILE = EXCEPTION_MESSAGE_BASE + "File { %s } corrupted or empty";
    public static final String EXCEPTION_ARTICLE_ALREADY_EXISTS = EXCEPTION_MESSAGE_BASE + "Same article already uploaded, but can have different name. Found ID's: { %s }";
    public static final String EXCEPTION_NO_FILE = EXCEPTION_MESSAGE_BASE + "File is not attached";
    public static final String EXCEPTION_ARTICLE_NOT_FOUND = EXCEPTION_MESSAGE_BASE + "Article { %s } was not found";
    public static final String EXCEPTION_UNACCEPTABLE_TYPE = EXCEPTION_MESSAGE_BASE + "File { %s } has unaccaptable extension";

    public static final String LOG_DB_REQUEST = "Database request: %s | ";
    public static final String LOG_ARTICLE_DELETED = LOG_DB_REQUEST.formatted("delete article") + "Article: %s";
    public static final String LOG_SEARCH_ARTICLE = LOG_DB_REQUEST.formatted("search article by id") + "ID: %s";
    public static final String LOG_GET_ALL_ARTICLES = LOG_DB_REQUEST.formatted("get all articles") + "Found %s articles";
    public static final String LOG_ARTICLE_SAVED = LOG_DB_REQUEST.formatted("article saved") + "ID: %s";
    public static final String LOG_FOUND_DUPLICATIONS = LOG_DB_REQUEST.formatted("check for duplicates") + "Found ID's: %s";

    public static final String LOG_REQUEST_RECEIVED = "Request received: %s | ";
    public static final String LOG_UPLOAD_ARTICLE_REQUEST_RECEIVED = LOG_REQUEST_RECEIVED.formatted("article uploading") + "Filename: %s";
    public static final String LOG_GET_ARTICLES_LIST_RECEIVED = LOG_REQUEST_RECEIVED.formatted("get articles list");
    public static final String LOG_GET_ARTICLE_RECEIVED = LOG_REQUEST_RECEIVED.formatted("get article") + "ID: %s";
    public static final String LOG_DELETE_ARTICLE_RECEIVED = LOG_REQUEST_RECEIVED.formatted("delete article") + "ID: %s";

    public static final String LOG_REQUEST_PROCESSED = "Request processed: %s | ";

    public static final String LOG_UPLOAD_ARTICLE_REQUEST_PROCESSED = LOG_REQUEST_PROCESSED.formatted("article uploading") + "ID: %s";
    public static final String LOG_GET_ARTICLES_LIST_PROCESSED = LOG_REQUEST_PROCESSED.formatted("get articles list");
    public static final String LOG_GET_ARTICLE_PROCESSED = LOG_REQUEST_PROCESSED.formatted("get article") + "Article: %s";
    public static final String LOG_DELETE_ARTICLE_PROCESSED = LOG_REQUEST_PROCESSED.formatted("delete article");
}
