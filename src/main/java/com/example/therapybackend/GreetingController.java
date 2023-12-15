package com.example.therapybackend;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final ChatGPT chatGPT;

    public GreetingController() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("MY_API_KEY");
        if (apiKey == null) {
            throw new IllegalStateException("API Key not found in environment variables");
        }
        this.chatGPT = new ChatGPT(apiKey);
    }

    @PostMapping("/greeting")
    public String greeting(@RequestBody String prompt) {
        return this.chatGPT.ask(prompt);
    }
}
