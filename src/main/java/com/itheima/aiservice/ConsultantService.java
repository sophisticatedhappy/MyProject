package com.itheima.aiservice;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
//        chatMemory = "chatMemory", //配置会话记忆对象
        chatMemoryProvider = "chatMemoryProvider" ,//配置会话记忆提供者对象
        contentRetriever = "contentRetriever"  //配置向量数据库检索对象

)
public interface ConsultantService {

    public String chat(String message) ;


    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chatOne(@MemoryId String memoryId,@UserMessage String message);

//    @UserMessage("你是小妲己，{{it}}")
//    public Flux<String> chatOne(@V(String message);
//    @UserMessage("你是小妲己，{{msg}}")
//    public Flux<String> chatOne(@V("msg") String message);
}
