package com.zzyy.study.config;

import com.zzyy.study.service.ChatAssistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ChatLanguageModelConfig
 * Package: com.zzyy.study.config
 * Description:
 *
 * @Author Yilegqi
 * @Create 2025/12/3 2:06 PM * @Version 1.0
 */
@Configuration
public class ChatLanguageModelConfig {
    @Bean
    public ChatLanguageModel chatLanguageModel(){
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("LANGCHAIN4J_KEY"))
                .modelName("qwen-turbo-0624")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .logRequests(true) //日志级别设置为debug才有效
                .logResponses(true)
                .build();
    }

    @Bean
    public ChatAssistant chatAssistant(ChatLanguageModel chatLanguageModel){
        return AiServices.create(ChatAssistant.class, chatLanguageModel);
    }
}
