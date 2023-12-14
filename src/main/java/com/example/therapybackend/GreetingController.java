package com.example.therapybackend;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

import com.lilittlecat.chatgpt.offical.ChatGPT;
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.POST, consumes = "text/plain")
    public String greeting(@RequestBody String payload) {
        ChatGPT chatGPT = new ChatGPT("");
        String hello = chatGPT.ask(payload);
        System.out.println(hello); // will be "\n\nHello! How may I assist you today?"
        return hello;
    }
}