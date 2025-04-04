package com.example.mybatisdemo.demos.web.demo;

public class QuickSort {

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotpos = partition(arr, left, right);
            quickSort(arr, left, pivotpos - 1);
            quickSort(arr, pivotpos + 1, right);
        }
    }

    /*
    {3,2,1,5,9,3}
    left 0
    right 5
    pivot = 3


     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
