package com.itheima.controller;

import com.itheima.aiservice.ConsultantService;
import com.itheima.pojo.Message;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class AIController {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private ConsultantService consultantService;

    @PostMapping("/2")
    public String chat2(@RequestBody Message message){
        String chat = consultantService.chat(message.getMessage());
        return chat;
    }

    @PostMapping("/1")
    public String chat(@RequestBody Message message){
        String chat = openAiChatModel.chat(message.getMessage());
        return chat;
    }

//    @PostMapping(value = "/3",produces = "text/html;charset=utf-8")
//    public Flux<String> chatThree(@RequestBody Message message){
//        Flux<String> stringFlux = consultantService.chatOne(message.getMessage());
//        return stringFlux;
//    }


    @GetMapping(value = "/4",produces = "text/html;charset=utf-8")
    public Flux<String> chatFour(@RequestParam("memoryId") String memoryId ,@RequestParam("message") String message){
        System.out.println("memoryId="+memoryId+"message="+message);
        Flux<String> stringFlux = consultantService.chatOne(memoryId,message);
        return stringFlux;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/world")
    public String world(){
        return "world";
    }
}
