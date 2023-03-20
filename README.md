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