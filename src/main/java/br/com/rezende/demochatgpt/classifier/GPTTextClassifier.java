package br.com.rezende.demochatgpt.classifier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class GPTTextClassifier {
    public static final String HTTPS_API_OPENAI_COM_V_1_CLASSIFICATIONS = "https://api.openai.com/v1/classifications";
    @Value("${openai-api-key}")
    private String apiKey;

    public static final String OPENAI_MODEL = "code-davinci-002";
    private final RestTemplate restTemplate = new RestTemplate();

    public GPTTextClassifier() {
    }

    public String classify(String text) {
        // The JSON payload with the input text and other parameters
        final String requestJson = "{\"model\":\"" + OPENAI_MODEL + "\",\"query\":\"" + text + "\"}";

        return restTemplate.postForObject(HTTPS_API_OPENAI_COM_V_1_CLASSIFICATIONS, requestJson, String.class);
    }

}
