package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 15655번 N과 M (6)
https://www.acmicpc.net/problem/15655

- 풀이법: 재귀로 조합 구현
  ㄴ time: 128
*/
public class Problem15654 {
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
		}

		Arrays.sort(src);

		sb = new StringBuilder();
		combination(src, M, new int[M], 0);

		System.out.println(sb);

	}

	private static void combination(int[] src, int toChoose, int[] chosen, int startIdx) {
		if (toChoose == 0) {
			print(chosen);
			return;
		}

		for (int i = startIdx; i < src.length; i++) {
			chosen[chosen.length - toChoose] = src[i];
			combination(src, toChoose - 1, chosen, i + 1);
		}
	}

	private static void print(int[] chosen) {
		for (int i = 0; i < chosen.length; i++) {
			sb.append(chosen[i]).append(" ");
		}
		sb.append("\n");
	}
}
