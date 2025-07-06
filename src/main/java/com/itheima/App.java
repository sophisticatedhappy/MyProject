package com.itheima;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
//        //2.构建OpenAiChatModel对象
//        OpenAiChatModel model = OpenAiChatModel.builder()
//                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
//                .apiKey("sk-97a9a8d114b94c6aa957a847b585f9a1")
//                .modelName("qwen-plus")
//                .logRequests(true)
//                .logResponses(true)
//                .build();
//
//        //3.调用chat方法,交互
//        String result = model.chat("东哥帅不帅?");
//        System.out.println(result);
    }
}
