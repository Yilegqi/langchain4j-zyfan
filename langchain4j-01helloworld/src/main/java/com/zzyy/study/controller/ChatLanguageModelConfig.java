//package com.zzyy.study.controller;
//
//import dev.langchain4j.model.chat.ChatLanguageModel;
//import dev.langchain4j.model.openai.OpenAiChatModel;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * ClassName: ChatLanguageModelConfig
// * Package: com.zzyy.study.controller
// * Description:
// *
// * @Author Yilegqi
// * @Create 2025/11/30 9:26 PM * @Version 1.0
// */
//@Configuration(proxyBeanMethods = false)
//public class ChatLanguageModelConfig {
//    @Bean
//    public ChatLanguageModel chatLanguageModel(){
//        return OpenAiChatModel.builder()
//                .apiKey(System.getenv("LANGCHAIN4J_KEY"))
//                .modelName("qwen-turbo-0624")
//                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1)")
//                .build();
//    }
//}
