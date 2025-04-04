package com.example.mybatisdemo.demos.web.demo;

public class QuickSortDemo {
    public static void main(String[] args) {

        int[] arr = {3,2,1,5,9,3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length - 1);
        for(int item : arr){
            System.out.print(item+" ");
        }
    }
}
