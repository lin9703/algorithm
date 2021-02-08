package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 8, 2021
 * @author lin9703
 * @problem SWEA 5215번 햄버거 다이어트
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=5215&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 21,208
 * @time 784
 * @caution 부분집합 - 재귀
 */
public class Problem5215 {
	static int L;
	static int[][] kal;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			kal = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				kal[i][0] = Integer.parseInt(st.nextToken());
				kal[i][1] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			powerset(N, new boolean[N]);

			// print
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void powerset(int toChoose, boolean[] chosen) {
		if (toChoose == 0) {
			result = Math.max(result, getSum(chosen));
			return;
		}

		chosen[chosen.length - toChoose] = true;
		powerset(toChoose - 1, chosen);
		chosen[chosen.length - toChoose] = false;
		powerset(toChoose - 1, chosen);

	}

	private static int getSum(boolean[] chosen) {
		int kalorie = 0;
		int taste = 0;
		for (int i = 0; i < chosen.length; i++) {
			if (chosen[i]) {
				taste += kal[i][0];
				kalorie += kal[i][1];
			}

			if (kalorie > L) {
				return 0;
			}
		}

		return taste;
	}

}
