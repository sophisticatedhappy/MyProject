package com.example.mybatisdemo.demos.web.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/singleton")
public class SingleLoginController {

    @GetMapping("/login")
    public Map<String,String> login(String userName, String password){
        Map<String,String> map=new HashMap<>();
        try{
            String token = Jwts.builder().setSubject(userName) //主题，可以放用户的详细信息
                    .setIssuedAt(new Date()) //token创建时间
                    .setExpiration(new Date(System.currentTimeMillis() + 60000)) //token过期时间
                    .setId("userId") //用户ID
                    //.setClaims(hashMap) //配置角色信息
                    .signWith(SignatureAlgorithm.HS256, "ChangSha") //加密方式和加密密码
                    .compact();
            //  System.out.println("token:"+token);
            map.put("code","1");
            map.put("msg","success");
            map.put("token",token);
            map.put("user",userName);
        }catch (Exception e){
            map.put("code","0");
            map.put("msg","fail");
            e.printStackTrace();
        }
        return map;
    }

}
