package br.com.rezende.demochatgpt.util;

import br.com.rezende.demochatgpt.model.DBName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenAIGenerator {
    private static final String HTTPS_API_OPENAI_COM_V_1_IMG_GENERATIONS = "https://api.openai.com/v1/images/generations";
    public static final String HTTPS_API_OPENAI_COM_V_1_COMPLETIONS = "https://api.openai.com/v1/completions";
    public static final String OPENAI_MODEL = "code-davinci-002";

    @Value("${openai-api-key}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     *
     * @param prompt
     * @param temperature
     * @param maxTokens
     * @param stop
     * @param logprobs
     * @param echo
     * @param n
     * @return
     */
    public String generateImages(String prompt, float temperature, int maxTokens, String stop, final int logprobs, final boolean echo, int n)
    {
        HttpHeaders headers = getHttpHeaders();

        // We are including only some of the parameters to the json request
        String requestJson = "{\"prompt\":\"" + prompt + "\",\"n\":" + n + "}";

        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(HTTPS_API_OPENAI_COM_V_1_IMG_GENERATIONS, request, String.class);
        return response.getBody();
    }

    /**
     * SQL generation using OpenAI APIs can also be used to improve the accuracy of data extraction processes.
     * @param sentence Text information to create. Ex:  all customers in São Paulo named José and have a last name that starts with a F
     * @oaran databaseName Name of Database.
     * @return The JSON response string containing the generated SQL query, which you can then parse and process as needed.
     */
    public String createSQLQuery(String sentence, DBName databaseName) {
        // The JSON payload with the input text and other parameters
        final String strPrompt = String.format("Create a %s query for %s?", databaseName, sentence);
        final String requestJson = "{\"prompt\":\"" + strPrompt+ "\",\"model\":\"" + OPENAI_MODEL + "\",stop=[\"#\", \";\"]}";

        return restTemplate.postForObject(HTTPS_API_OPENAI_COM_V_1_COMPLETIONS, requestJson, String.class);
    }

    /**
     * Default OpenAI GPT API Http Headers.
     * @return Header types and client authorization API.
     */
    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        return headers;
    }

}
