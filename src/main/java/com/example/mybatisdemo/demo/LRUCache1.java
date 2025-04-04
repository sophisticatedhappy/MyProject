package com.example.mybatisdemo.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1<K,V> extends LinkedHashMap<K,V> {
    private Integer capacity;

    public LRUCache1(Integer capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > capacity;
    }
}
