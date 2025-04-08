package com.example.mybatisdemo.demo.leetcode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*

给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。

在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。

返回插入之后的 intervals。

注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 */
public class LC57 {
    public static void main(String[] args) {
        List<int[]> ints = generateData();
        sortList(ints);
        for(int[] item : ints){
            System.out.print(item[0]+"->"+item[1]);
            System.out.println();
        }
    }
    public static List<int[]> generateData(){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,3});
        list.add(new int[]{1,4});
        list.add(new int[]{4,5});
        list.add(new int[]{3,6});
        return list;
    }

    public static void sortList(List<int[]> list){
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }



}
