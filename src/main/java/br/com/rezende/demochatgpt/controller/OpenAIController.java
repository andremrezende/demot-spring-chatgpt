package br.com.rezende.demochatgpt.controller;

import br.com.rezende.demochatgpt.classifier.GPTTextClassifier;
import br.com.rezende.demochatgpt.model.CreateSQLQueryRequest;
import br.com.rezende.demochatgpt.model.DBName;
import br.com.rezende.demochatgpt.model.GenerateImagesRequest;
import br.com.rezende.demochatgpt.util.OpenAIGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {
    private final OpenAIGenerator openAIGenerator;
    private final GPTTextClassifier gptTextClassifier;

    public OpenAIController(OpenAIGenerator openAi, GPTTextClassifier gptTextClassifier)
    {
        this.openAIGenerator = openAi;
        this.gptTextClassifier = gptTextClassifier;
    }

    @PostMapping("/generateImages")
    public String generateImages(@RequestBody GenerateImagesRequest request)
    {
        return openAIGenerator.generateImages(request.prompt(), request.temperature(), request.maxTokens(), request.stop(),
                request.logprobs(), request.echo(), request.n());
    }

    @PostMapping("/createQuery")
    public String createQuery(@RequestBody CreateSQLQueryRequest request)
    {
        return openAIGenerator.createSQLQuery(request.sentence(), DBName.MYSQL);
    }

    @PostMapping("/classify")
    public String classify(@RequestBody CreateSQLQueryRequest request)
    {
        return gptTextClassifier.classify("The quick brown fox jumps over the lazy dog.");
    }
}
