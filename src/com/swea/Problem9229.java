package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 8, 2021
 * @author lin9703
 * @problem SWEA 9229번 한빈이와 Spot Mart
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE&problemTitle=9229&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 25,520
 * @time 149
 * @caution 조합 + 가지치기
 */
public class Problem9229 {
	static int M;
	static int[] weights;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			result = -1; // result 초기화

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			weights = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			combination(2, 0, 0);

			// print
			sb.append("#").append(t).append(" ").append(result).append("\n");

		}

		System.out.println(sb);
	}

	private static void combination(int toChoose, int startIdx, int sum) {
		if (toChoose == 0) {
			result = Math.max(result, sum);
			return;
		}

		for (int i = startIdx; i < weights.length; i++) {
			int temp = sum;
			temp += weights[i];
			if (temp > M) {
				continue;
			}
			combination(toChoose - 1, i + 1, temp);
		}
	}

}
