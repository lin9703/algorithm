package com.practice;

import java.util.Arrays;

public class QuickSortVersion01 {

    public static void main(String[] args) {
        int[] arr1 = {};
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {6, 4, 1, 8, 9, 2, 7, 5, 3};
        System.out.println(Arrays.toString(quickSort(arr2, 0, arr2.length - 1)));
        int[] arr3 = {6, 4, 2, 10, 9, 1, 7, 11, 5, 3, 0, 8};
        System.out.println(Arrays.toString(quickSort(arr3, 0, arr3.length - 1)));
        int[] arr4 = {1};
        System.out.println(Arrays.toString(quickSort(arr4, 0, arr4.length - 1)));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (arr == null) return null;

        if (left >= right) return arr;

        int pivotPos = partition(arr, left, right);

        arr = quickSort(arr, left, pivotPos - 1);
        arr = quickSort(arr, pivotPos + 1, right);

        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        if (arr == null || left < 0) return -1;
        int pivotValue = arr[right];
        int endOfLowBlock = left - 1;

        for (int pos = left; pos < right; ++pos) {
            if (pivotValue > arr[pos]) {
                endOfLowBlock += 1;
                swapValue(arr, pos, endOfLowBlock);
            }
        }
        endOfLowBlock += 1;
        swapValue(arr, right, endOfLowBlock);

        return endOfLowBlock;
    }

    public static void swapValue(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
