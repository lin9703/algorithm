package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1018번 체스판 다시 칠하기
https://www.acmicpc.net/problem/1018

- 풀이법: 브루트포스
  ㄴ time: 148
*/
public class Problem1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] chess = new char[N][N];
		for (int i = 0; i < N; i++) {
			chess[i] = br.readLine().toCharArray();
		}

		int result = Integer.MAX_VALUE;
		int change;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				change = 0;
				for (int p = 0; p < 8; p += 2) {
					for (int q = 0; q < 8; q += 2) {
						if (chess[i + p][j + q] != 'W')
							change++;
						if (chess[i + p][j + q + 1] != 'B')
							change++;
						if (chess[i + p + 1][j + q] != 'B')
							change++;
						if (chess[i + p + 1][j + q + 1] != 'W')
							change++;
					}

					if (change >= result) {
						break;
					}
				}

				if (change < result) {
					result = change;
				}
			}
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				change = 0;
				for (int p = 0; p < 8; p += 2) {
					for (int q = 0; q < 8; q += 2) {
						if (chess[i + p][j + q] != 'B')
							change++;
						if (chess[i + p][j + q + 1] != 'W')
							change++;
						if (chess[i + p + 1][j + q] != 'W')
							change++;
						if (chess[i + p + 1][j + q + 1] != 'B')
							change++;
					}
					if (change >= result) {
						break;
					}
				}

				if (change < result) {
					result = change;
				}
			}
		}

		System.out.println(result);
	}
}
