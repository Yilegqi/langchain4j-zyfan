package com.zzyy.study.controller;

import dev.langchain4j.model.chat.ChatLanguageModel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloLangChain4JController
 * Package: com.zzyy.study.controller
 * Description:
 *
 * @Author Yilegqi
 * @Create 2025/11/30 8:10 PM * @Version 1.0
 */
@RestController
@Slf4j
public class HelloLangChain4JController {
    @Resource
    private ChatLanguageModel chatLanguageModel;

    @GetMapping(value = "/langchain4j/hello")
    public String hello(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt){
        String result = chatLanguageModel.generate(prompt);
        System.out.println("通过langchain4j 调用 qwen-turbo-0624 模型返回结果：\n" + result);
        return result;
    }
}
