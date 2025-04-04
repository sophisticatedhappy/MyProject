package com.example.mybatisdemo.demo;

import java.util.Map;

public class LRUCacheDemo {
    public static void main(String[] args) {

        LRUCache<Integer,String> cache = new LRUCache<>(3);

        cache.put(1,"hepan");
        cache.put(2,"zouly");
        cache.put(3,"baby");
        cache.put(4,"hepan-hepan");

        System.out.println(cache.size());
        for(Map.Entry<Integer,String> entry : cache.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
