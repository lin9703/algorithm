package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 15654번 N과 M (5)
https://www.acmicpc.net/problem/15654

- 풀이법: 재귀로 순열 구현
  ㄴ time: 360
*/
public class Problem15655 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] src = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < src.length; i++) {
			src[i] = Integer.parseInt(st.nextToken());
			;
		}

		Arrays.sort(src);

		sb = new StringBuilder();
		permutation(src, M, new int[M], new boolean[N]);

		System.out.println(sb);

	}

	private static void permutation(int[] src, int toChoose, int[] chosen, boolean[] visited) {
		if (toChoose == 0) {
			print(chosen);
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if (!visited[i]) {
				chosen[chosen.length - toChoose] = src[i];
				visited[i] = true;
				permutation(src, toChoose - 1, chosen, visited);
				visited[i] = false;
			}
		}
	}

	private static void print(int[] chosen) {
		for (int i = 0; i < chosen.length; i++) {
			sb.append(chosen[i]).append(" ");
		}
		sb.append("\n");
	}
}
