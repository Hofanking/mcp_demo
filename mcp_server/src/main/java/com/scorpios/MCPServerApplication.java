package com.scorpios;


import com.scorpios.service.OpenMeteoService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MCPServerApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(MCPServerApplication.class,args);
    }


    @Bean
    public ToolCallbackProvider weatherTools(OpenMeteoService openMeteoService){
        return MethodToolCallbackProvider.builder()
                .toolObjects(openMeteoService)
                .build();
    }

    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
