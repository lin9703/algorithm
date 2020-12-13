package com.practice;

import java.util.Arrays;

public class QuickSortVersion02 {

    public static void main(String[] args) {
        int[] arr1 = {};
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {6, 4, 1, 8, 9, 2, 7, 5, 3};
        System.out.println(Arrays.toString(quickSort(arr2, 0, arr2.length - 1)));
        int[] arr3 = {6, 4, 2, 10, 9, 1, 7, 11, 5, 3, 0, 8};
        System.out.println(Arrays.toString(quickSort(arr3, 0, arr3.length - 1)));
        int[] arr4 = {1};
        System.out.println(Arrays.toString(quickSort(arr4, 0, arr4.length - 1)));
        int[] arr5 = {5, 6, 4, 4, 7, 8};
        System.out.println(Arrays.toString(quickSort(arr5, 0, arr5.length - 1)));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (arr == null) return null;
        if (left >= right) return arr;

        int L = left;
        int R = right;
        int pivotPos = arr[(left + right) / 2]; // pivot을 배열의 가운데 위치한 요소로 결정

        while (L <= R) {
            while (arr[L] < pivotPos) L++; // 피벗 왼쪽에는 피벗보다 작은 원소들이 위치해야 하고 크거나 같은 원소가 있으면 반복문을 나온다.
            while (arr[R] > pivotPos) R--; // 피벗 오른쪽에는 피벗보다 큰 원소들이 위치해야 하고 작거나 같은 원소가 있으면 반복문을 나온다.

            if (L <= R) {
                if (L != R) {
                    swapValue(arr, L, R); // 두 원소의 위치를 교환 -> 피벗 기준으로 왼쪽에는 작은 원소가, 오른쪽에는 큰 원소 위치
                }
                L++;
                R--;
            }
        }

        // 피벗의 왼쪽과 오른쪽의 정렬되지 않은 부분에 대해 퀵 정렬 수행
        if (left < R) arr = quickSort(arr, left, R);
        if (L < right) arr = quickSort(arr, L, right);

        return arr;
    }

    public static void swapValue(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
}
