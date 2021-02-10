package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 8, 2021
 * @author lin9703
 * @problem SWEA 5215번 햄버거 다이어트
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=5215&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 21,208 -> 21,508 -> 19,984
 * @time 784 -> 가지치기 후 706 (별 효과 X) -> 매개변수로 값 저장 후 169
 * @caution 부분집합 - 재귀
 */
public class Problem5215 {
	static int N, L;
	static int[][] ingredient;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			ingredient = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}

			result = 0;
			powerset(0, 0, 0);

			// print
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void powerset(int toChoose, int taste, int kal) {
		if (kal > L) {
			return;
		}
		if (toChoose == N) {
			result = Math.max(result, taste);
			return;
		}

		powerset(toChoose + 1, taste + ingredient[toChoose][0], kal + ingredient[toChoose][1]);
		powerset(toChoose + 1, taste, kal);

	}

}
