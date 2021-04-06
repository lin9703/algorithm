package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2579번 계단 오르기
https://www.acmicpc.net/problem/2579

- 풀이법: DP 
  ㄴ time: 80
*/
public class Problem2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxIdx = Math.max(3, N + 1);
        int[] stairs = new int[maxIdx];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[maxIdx];
        dp[0] = 0;
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = stairs[i] + Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
