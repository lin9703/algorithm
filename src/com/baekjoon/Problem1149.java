package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1149번 RGB거리
https://www.acmicpc.net/problem/1149

- 풀이법: DP 
  ㄴ time: 96
*/
public class Problem1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] housePrice = new int[N][3];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				housePrice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][3];
		for (int i = 0; i < 3; i++) {
			dp[0][i] = housePrice[0][i];
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + housePrice[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + housePrice[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + housePrice[i][2];
		}

		int min = Math.min(dp[N - 1][0], dp[N - 1][1]);
		min = Math.min(min, dp[N - 1][2]);

		System.out.println(min);
	}
}
