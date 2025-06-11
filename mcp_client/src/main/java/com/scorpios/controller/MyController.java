package com.scorpios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    private final ChatClient chatClient;

    public MyController(ChatClient.Builder chatClientBuilder, @Autowired ToolCallbackProvider tools) {
        this.chatClient = chatClientBuilder.defaultTools(tools).build();
    }


    @GetMapping("/test")
    public String index(){
        logger.info("TestController test......");
        return "hello world";
    }

    @GetMapping("/ai")
    String ai(@RequestParam(name="input") String input) {
        logger.info("用户输入：" + input);
        String result = this.chatClient.prompt()
                .user(input)
                .call()
                .content();
        logger.info("模型回答：" + result);
        return result;
    }

    @GetMapping("/weather")
    String weather(@RequestParam(name="input") String input) {
        logger.info("用户输入：" + input);
        String result = this.chatClient.prompt(input + "今天天气如何？")
                .call()
                .content();
        logger.info("模型回答：" + result);
        return result;
    }


//    @GetMapping("/query/currentTime/{country}")
//    Flux<String> queryCurrentTime(@PathVariable String country){
//        return this.chatClient
//                .prompt(new PromptTemplate("调用本地工具查询国家{country}当前时间")
//                        .create(Map.of("country", country)))
//                .stream()
//                .content();
//    }


}