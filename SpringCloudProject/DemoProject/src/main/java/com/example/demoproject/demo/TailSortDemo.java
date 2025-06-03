package com.example.demoproject.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TailSortDemo {
    public static String[] tailSort(String[] arr) {
        // 使用自定义的比较器对数组进行排序
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1.length();
                int len2 = s2.length();
                int minLen = Math.min(len1, len2);
                // 从字符串的尾部开始比较
                for (int i = 0; i < minLen; i++) {
                    char c1 = s1.charAt(len1 - 1 - i);
                    char c2 = s2.charAt(len2 - 1 - i);
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
                // 如果前面的字符都相同，比较字符串的长度
                return len1 - len2;
            }
        });
        return arr;
    }

    public static void main(String[] args) {
        String[] arr = {"abf","abd","abc","abe"};
        String[] sortedArr = tailSort(arr);
        // 输出排序后的数组
        for (String s : sortedArr) {
            System.out.print(s + " ");
        }
    }
}
