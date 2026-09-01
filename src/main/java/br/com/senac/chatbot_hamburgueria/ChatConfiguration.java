package br.com.senac.chatbot_hamburgueria;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource; // ESSE DAQUI <-----

@Configuration
public class ChatConfiguration {

    @Bean
    ChatClient chatClient(
            ChatClient.Builder builder,
            @Value("classpath:/prompts/system-prompt-hamburgueria.st") Resource systemPrompt
            ) {
        return  builder
                .defaultSystem(systemPrompt)
                .build();
    }
}
