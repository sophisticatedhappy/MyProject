package com.example.mybatisdemo;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteWorkbook;
import com.example.mybatisdemo.demos.web.entity.Subject;
import com.example.mybatisdemo.demos.web.mapper.SubjectMapper;
import com.example.mybatisdemo.demos.web.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@SpringBootTest
class MybatisDemoApplicationTests {


    @Autowired
    private SubjectService subjectMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    void contextLoads() {
        List<Subject> subjects = subjectMapper.selectAll();
        subjects.stream().forEach(item ->{
            System.out.println(item);
        });
    }

    @Test
    void testForRedis(){
        redisTemplate.opsForValue().set("location","changsha");
        String location = redisTemplate.opsForValue().get("location");
        System.out.println(location);
    }

    @Test
    void testForHash(){
        redisTemplate.opsForHash().put("hash1","hh","你笑啥");
        redisTemplate.expire("hash1",3, TimeUnit.MINUTES);
//        Object o = redisTemplate.opsForHash().get("hash1", "hh");
//        System.out.println(o);
    }

    @Test
    void testSubject(){
        List<Subject> subjects = subjectMapper.selectAll();
        Map<String, Subject> map = subjects.stream()
                .collect(Collectors.toMap(
                        Subject::getTitle,
                        identity(),
                        (existing, replacement) -> existing // 或根据需求选择其他策略
                ));
        Subject subject = map.get("Linux");
        System.out.println(subject);
    }

    Map<String,Subject> ops(List<Subject> subjects){
        Map<String ,Subject> map = new HashMap<>();
        for(Subject subject:subjects){
            map.put(subject.getTitle(),subject);
        }
        return map;
    }
    //优化


    @Test
    void testEasyExcel(){

        WriteWorkbook workbook = new WriteWorkbook();

        ExcelWriter excelWriter = new ExcelWriter(workbook);
    }

}
