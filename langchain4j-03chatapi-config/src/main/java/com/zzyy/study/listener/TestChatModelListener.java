package com.zzyy.study.listener;

import cn.hutool.core.util.IdUtil;
import dev.langchain4j.model.chat.listener.ChatModelErrorContext;
import dev.langchain4j.model.chat.listener.ChatModelListener;
import dev.langchain4j.model.chat.listener.ChatModelRequestContext;
import dev.langchain4j.model.chat.listener.ChatModelResponseContext;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName: TestChatModelListener
 * Package: com.zzyy.study.listener
 * Description:
 *
 * @Author Yilegqi
 * @Create 2025/12/3 2:56 PM * @Version 1.0
 */
@Slf4j
public class TestChatModelListener implements ChatModelListener {
    @Override
    public void onRequest(ChatModelRequestContext requestContext) {
        //onRequest 配置的 k:v 键值对，在onResponse阶段可以获得，上下文传递参数好用
        String uuidValue = IdUtil.simpleUUID();
        requestContext.attributes().put("TraceID", uuidValue);
        log.info("请求参数 requestContext:{}", requestContext + "\t" + uuidValue);
    }

    @Override
    public void onResponse(ChatModelResponseContext responseContext) {
        Object object = responseContext.attributes().get("TraceID");
        log.info("返回结果 responseContext:{}", object);
    }

    @Override
    public void onError(ChatModelErrorContext errorContext) {
        log.error("请求异常 ChatModelErrorContext:{}" + errorContext);
    }
}
