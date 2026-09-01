package br.com.senac.chatbot_hamburgueria;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private final ChatClient chatClient;

    public HelloController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    record ChatHelloInput(
            String prompt
    ){}

    record ChatHelloOutput(
            String message
    ){}

    @PostMapping
    @Operation(summary = "Envia uma mensagem para o Gemini")
    public ChatHelloOutput hello(@RequestBody ChatHelloInput input) {
        String chatResponse = chatClient.prompt()
                .user(input.prompt)
                .call()
                .content();

        return new ChatHelloOutput(chatResponse);
    }
}
