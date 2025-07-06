package com.itheima.repository;


import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.List;

@Repository
public class RedisChatMemoryStore implements ChatMemoryStore {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        String messages = stringRedisTemplate.opsForValue().get(memoryId.toString());
        List<ChatMessage> chats = ChatMessageDeserializer.messagesFromJson(messages);
        return chats;
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        String messages = ChatMessageSerializer.messagesToJson(list);
        stringRedisTemplate.opsForValue().set(memoryId.toString(),messages, Duration.ofDays(1));
    }

    @Override
    public void deleteMessages(Object memoryId) {
        String andDelete = stringRedisTemplate.opsForValue().getAndDelete(memoryId.toString());
    }
}
