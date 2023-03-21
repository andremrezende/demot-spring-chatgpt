package br.com.rezende.demochatgpt.model;

public record GenerateImagesRequest (String prompt,
                                     float temperature,
                                     int maxTokens,
                                     String stop,
                                     int logprobs,
                                     boolean echo, int n) {
}
