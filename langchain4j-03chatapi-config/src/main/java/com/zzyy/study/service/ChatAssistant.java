package com.zzyy.study.service;

import dev.langchain4j.data.message.ChatMessage;

/**
 * ClassName: ChatAssistant
 * Package: com.zzyy.study.service
 * Description:
 *
 * @Author Yilegqi
 * @Create 2025/12/3 11:42 AM * @Version 1.0
 */
public interface ChatAssistant {
    String chat(String prompt);

    //收费玩法 显示用了多少token
    ChatMessage chat(ChatMessage... messages);
}
