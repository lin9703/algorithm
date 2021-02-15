package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 3040번 백설 공주와 일곱 난쟁이
https://www.acmicpc.net/problem/3040

- 첫 번째 풀이법: 조합 (비트마스크 flag 이용)  
  ㄴ time: 124
*/
public class Problem3040 {
	static int[] dwarfs;
	static int finding;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dwarfs = new int[9];
		finding = -100;
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			finding += dwarfs[i];
		}

		combination(0, 0, 0, 0);

		System.out.println(sb);

	}

	private static void combination(int toChoose, int flag, int startIdx, int sum) {
		if (finding < sum)
			return;
		if (toChoose == 2) {
			if (sum == finding) {
				for (int i = 0; i < 9; i++) {
					if ((flag & 1 << i) == 0) {
						sb.append(dwarfs[i]).append("\n");
					}
				}
			}
			return;
		}

		for (int i = startIdx; i < 9; i++) {
			combination(toChoose + 1, flag | 1 << i, i + 1, sum + dwarfs[i]);
		}
	}

}
