package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2447번 별 찍기 - 10
https://www.acmicpc.net/problem/2447

- 풀이법: 재귀
  ㄴ time: 408
*/
public class Problem2447 {
	static char[][] stars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		stars = new char[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], '*');
		}

		makeStars(stars, 0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void makeStars(char[][] stars, int startX, int startY, int n) {
		int t = n / 3;

		for (int i = startX + t; i < startX + (2 * t); i++) {
			for (int j = startY + t; j < startY + (2 * t); j++) {
				stars[i][j] = ' ';
			}
		}

		if (n <= 3) {
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				makeStars(stars, startX + t * i, startY + t * j, t);
			}
		}

	}
}
