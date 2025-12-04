package com.zzyy.study.controller;

import com.zzyy.study.service.ChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.output.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ChatLanguageModelController
 * Package: com.zzyy.study.controller
 * Description:
 *
 * @Author Yilegqi
 * @Create 2025/12/2 2:06 PM * @Version 1.0
 */
@RestController
@Slf4j
public class ChatLanguageModelController {
    @Resource
    private ChatLanguageModel chatLanguageModel;
    @Resource
    private ChatAssistant chatAssistant;

    //测试Configuration配置：把apiKey配置到环境变量之后的测试
    @GetMapping(value = "/chatlanguagemodel/hello")
    public String hello(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt){
        String result = chatLanguageModel.generate(prompt);
        System.out.println("通过 langchain4j 调用 qwen-turbo-0624 模型返回结果：" + result);
        return result;
    }

    //可以计算token，输入的算token消耗，输出的也算token消耗
    @GetMapping(value = "/chatlanguagemodel/usermessage")
    public String userMessage(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt){
        UserMessage userMessage = UserMessage.from(prompt);
        Response<AiMessage> messageResponse = chatLanguageModel.generate(userMessage);
        System.out.println("通过 langchain4j 调用 qwen-turbo-0624 模型返回结果：" + messageResponse);
        return  messageResponse.toString();
    }

    @GetMapping(value = "/chatlanguagemodel/assistant")
    public String assistant(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt){
        String chat = chatAssistant.chat(prompt);
        System.out.println("通过 langchain4j 调用 qwen-turbo-0624 模型返回结果：" + chat);
        return chat;
    }
}
