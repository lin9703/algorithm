package com.leetcode;

/*
LeetCode 1351번 Count Negative Numbers in a Sorted Matrix
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

- 풀이법: binary search
  ㄴ time: 0 ms
*/
public class Problem1351 {
    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        int result = countNegatives(grid);

        System.out.println(result);
    }

    static public int countNegatives(int[][] grid) {
        int gridCol = grid.length;
        int gridRow = grid[0].length;

        int negativeCount = 0;
        for (int i = 0; i < gridCol; i++) {
            negativeCount += binarySearch(grid[i], gridRow);
        }

        return negativeCount;
    }

    private static int binarySearch(int[] array, int arrayLen) {
        int start = 0;
        int end = arrayLen - 1;
        int negativeCount = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = array[mid];

            if (midValue < 0) {
                negativeCount += end - mid + 1;
                end = mid - 1;
            } else if (midValue >= 0) {
                start = mid + 1;
            }
        }

        return negativeCount;
    }
}
