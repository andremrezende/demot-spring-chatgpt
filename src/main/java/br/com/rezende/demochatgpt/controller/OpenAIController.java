package br.com.rezende.demochatgpt.controller;

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

    public OpenAIController(OpenAIGenerator openAi)
    {
        this.openAIGenerator = openAi;
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
}
