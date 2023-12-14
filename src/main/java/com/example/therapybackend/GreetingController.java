package com.example.therapybackend;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final ChatGPT chatGPT;

    public GreetingController() {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("MY_API_KEY");
        if (apiKey == null) {
            throw new IllegalStateException("API Key not found in environment variables");
        }
        this.chatGPT = new ChatGPT(apiKey);
    }

    @RequestMapping(
            value = {"/greeting"},
            method = {RequestMethod.POST},
            consumes = {"text/plain"}
    )
    public String greeting(@RequestBody String payload) {
        String hello = this.chatGPT.ask(payload);
        System.out.println(hello);
        return hello;
    }
}
