package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1904번 01타일
https://www.acmicpc.net/problem/1904

- 풀이법: DP (3번 실패 - dp 값이 int 범위를 초과하기 때문에 항상 15746으로 나눠줘야 한다)
  ㄴ time: 96
*/
public class Problem1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int idx = Math.max(3, N + 1);
        int[] dp = new int[idx];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N] % 15746);
    }
}
