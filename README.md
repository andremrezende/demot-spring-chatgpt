# Demo Spring and ChatGPT
ChatGPT is a powerful language model developed by OpenAI that can be used to generate human-like text. 
The OpenAI API allows developers to access the model and use it in their own applications. 

## Set up
Before getting started, you will need to sign up for an API key on the OpenAI website
https://beta.openai.com/account/api-keys.
Once you have your API key, and the follow environment variable before start it:
```
OPENAI_API_KEY
```

After that, you can start making requests to the API.

# How does it work?
This class uses the Spring RestTemplate library to send a POST request to the OpenAI API’s generate images endpoint with the given prompt and the number of images that you would like to receive in response. There are some other optional parameters that you can check on the link below if needed: https://beta.openai.com/docs/api-reference/images/create

# Time to test our API 
## Creating an image
Now that we have the endpoint ready, we can start the server and use the below URL to make a POST request from Postman or any other API testing tool.
http://localhost:8080/generateImages
```json
{
    "prompt": "A cyte baby takung sumbath",
    "n": 3
}
```

You can see the Json request body with value for prompt and n. n=3 means that we would receive 5 generated images in response. And we do receive 3 image URLs related to the prompt text that we just sent.

Now you can copy these URLs and paste them in your browser to view the actual images.

## Creating a MySQL Query
One of the key advantages of SQL generation using OpenAI APIs is its ability to understand natural language sentences
and convert them into SQL queries. This can be done using a machine learning
model that has been trained on a large dataset of natural language sentences and
corresponding SQL queries. The Codex model series is a descendant of GPT-3 series
that’s been trained on both natural language and billions of lines of code.

SQL generation using OpenAI APIs can also be used to improve the accuracy of data extraction
processes. Since the model is trained on a large dataset of natural language
sentences and corresponding SQL queries, it can understand the nuances and subtleties of
natural language, and generate more accurate SQL queries. Additionally, this can
also help to reduce human errors as the model is generating the query instead of human.

Below is an example of how you can use the Spring RestTemplate to make a call to the OpenAI 
GPT-3 API endpoint in Java.
http://localhost:8080/createQuery

```json
{
    "sentence": "all customers in São Paulo named José and have a last name that starts with a F"
}
```