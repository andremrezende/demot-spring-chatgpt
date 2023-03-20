package br.com.rezende.demochatgpt.model;

public class GenerateImagesRequest {
    private String prompt;
    private float temperature;
    private int maxTokens;
    private String stop;
    private int logprobs;
    private boolean echo;
    private int n;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(int logprobs) {
        this.logprobs = logprobs;
    }

    public boolean isEcho() {
        return echo;
    }

    public void setEcho(boolean echo) {
        this.echo = echo;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
