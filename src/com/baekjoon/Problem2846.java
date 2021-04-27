package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2846번 오르막길
https://www.acmicpc.net/problem/2846

- 풀이법: 구현
  ㄴ time: 84
*/
public class Problem2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int N = Integer.parseInt(input.readLine());
        int[] nums = new int[N];

        tokenizer = new StringTokenizer(input.readLine());
        for (int index = 0; index < N; index++) {
            nums[index] = Integer.parseInt(tokenizer.nextToken());
        }

        int start = 0;
        int end = 0;
        int maxDiff = 0;
        for (int index = 1; index < N; index++) {
            if (nums[index] > nums[index - 1]) {
                end++;
            } else {
                maxDiff = Math.max(maxDiff, nums[end] - nums[start]);
                start = index;
                end = index;
            }
        }

        maxDiff = Math.max(maxDiff, nums[end] - nums[start]);

        System.out.println(maxDiff);
    }
}
