package com.scorpios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final ChatClient chatClient;

    public TestController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/test")
    public String index(){
        logger.info("TestController test......");
        return "hello world";
    }

    @GetMapping("/ai")
    String generation(@RequestParam(name="input") String input) {
        logger.info("用户输入：" + input);
        String result = this.chatClient.prompt()
                .user(input)
                .call()
                .content();
        logger.info("模型回答：" + result);
        return result;
    }

}
