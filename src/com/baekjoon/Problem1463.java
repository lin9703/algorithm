package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1463번 1로 만들기
https://www.acmicpc.net/problem/1463

- 풀이법: DP 
  ㄴ time: 100
*/
public class Problem1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;

			if (i % 3 == 0) {
				min = Math.min(min, dp[i / 3] + 1);
			}
			if (i % 2 == 0) {
				min = Math.min(min, dp[i / 2] + 1);
			}
			if (i > 1) {
				min = Math.min(min, dp[i - 1] + 1);
			}

			dp[i] = min;
		}

		System.out.println(dp[N]);
	}
}
