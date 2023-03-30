package br.com.rezende.demochatgpt.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class GPTHeaders {

    /**
     * Default OpenAI GPT API Http Headers.
     * @return Header types and client authorization API.
     */
    public static HttpHeaders getHttpHeaders(String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        return headers;
    }
}
