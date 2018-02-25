package ru.aizen.domain;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import ru.aizen.domain.translate.Dictionary;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AbbyyClient {
    private HttpClient httpClient;

    private static final String HOST = "developers.lingvolive.com";
    private static final int PORT = 443;
    private static final String AUTHENTICATE = "/api/v1.1/authenticate";
    private static final String TRANSLATION = "/api/v1/Translation";
    private static final String WORD_LIST = "api/v1/WordList";
    private static final String MINI_CARD = "api/v1/Minicard";
    private static final String SEARCH = "api/v1/Search";
    private static final String ARTICLE = "api/v1/Article";
    private static final String SUGGEST = "api/v1/Suggests";
    private static final String WORD_FORM = "api/v1/WordForms";
    private static final String SOUND = "pi/v1/Sound";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_BASIC = "Basic ";
    private static final String AUTHORIZATION_BEARER = "Bearer ";

    private String authorizationKey;


    private static final HttpHost lingvolive = new HttpHost(HOST, PORT, "https");

    public AbbyyClient(String key) throws IOException {
        this.httpClient = HttpClients.createDefault();
        authorize(key);
    }

    private void authorize(String key) throws IOException {
        HttpPost post = new HttpPost(AUTHENTICATE);
        post.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BASIC + key);
        authorizationKey = EntityUtils.toString(httpClient.execute(lingvolive, post).getEntity());
    }

    public String getCaseSensitiveTranslation(String text, Integer source, Integer destination) throws IOException, URISyntaxException {
        return getTranslation(text, source, destination, true);
    }

    public String getTranslation(String text, Integer source, Integer destination) throws IOException, URISyntaxException {
        return getTranslation(text, source, destination, false);
    }

    public String getTranslation(String text, Integer source, Integer destination, Boolean isCaseSensitive) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(TRANSLATION)
                .addParameter("text", text)
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .addParameter("isCaseSensitive", isCaseSensitive.toString())
                .build();
        return executeGet(uri);
    }

    public String getTranslation(String text, Integer source, Integer destination, Dictionary dictionary) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(ARTICLE)
                .addParameter("text", text)
                .addParameter("dict", dictionary.getName())
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .build();
        return executeGet(uri);
    }

    public String getWordList(String prefix, Integer source, Integer destination, Integer pageSize, Integer startPos) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(WORD_LIST)
                .addParameter("prefix", prefix)
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .addParameter("pageSize", pageSize.toString())
                .addParameter("startPos", startPos.toString())
                .build();
        return executeGet(uri);
    }

    public String getMiniCard(String text, Integer source, Integer destination) throws URISyntaxException, IOException {
        URI uri = new URIBuilder(MINI_CARD)
                .addParameter("text", text)
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .build();
        return executeGet(uri);
    }

    public String getSearch(String text, Integer source, Integer destination,
                            String searchZone, Integer startIndex, Integer pageSize) throws URISyntaxException, IOException {
        URI uri = new URIBuilder(SEARCH)
                .addParameter("text", text)
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .addParameter("searchZone", searchZone)
                .addParameter("startIndex", startIndex.toString())
                .addParameter("pageSize", pageSize.toString())
                .build();
        return executeGet(uri);
    }

    public String getSuggest(String text, Integer source, Integer destination) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(SUGGEST)
                .addParameter("text", text)
                .addParameter("srcLang", source.toString())
                .addParameter("dstLang", destination.toString())
                .build();
        return executeGet(uri);
    }

    public String getWordForm(String text, Integer lang) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(WORD_FORM)
                .addParameter("text", text)
                .addParameter("lang", lang.toString())
                .build();
        return executeGet(uri);
    }

    public String getSound(Dictionary dictionary, String fileName) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(SOUND)
                .addParameter("dictionaryName", dictionary.getName())
                .addParameter("fileName", fileName)
                .build();
        return executeGet(uri);
    }

    private String executeGet(URI uri) throws IOException {
        //todo check code
        HttpGet get = new HttpGet(uri);
        get.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_BEARER + authorizationKey);
        return EntityUtils.toString(httpClient.execute(lingvolive, get).getEntity());
    }
}
