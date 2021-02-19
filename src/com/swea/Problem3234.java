package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 19, 2021
 * @author lin9703
 * @problem SWEA 3234번 준환이의 양팔저울
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw&categoryId=AWAe7XSKfUUDFAUw&categoryType=CODE&problemTitle=3234&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 20,252
 * @time 979
 * @caution
 */
public class Problem3234 {
	static int N;
	static int[] weights;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			weights = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			permutation(0, new int[N], 0);

			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	private static void permutation(int toChoose, int[] chosen, int flag) {
		if (toChoose == N) {
			powerset(chosen, 1, chosen[0], 0);
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			chosen[toChoose] = weights[i];
			permutation(toChoose + 1, chosen, flag | 1 << i);
		}
	}

	private static void powerset(int[] order, int toChoose, int leftSum, int rightSum) {
		if (leftSum < rightSum)
			return;
		if (toChoose == N) {
			cnt++;
			return;
		}

		powerset(order, toChoose + 1, leftSum + order[toChoose], rightSum);
		powerset(order, toChoose + 1, leftSum, rightSum + order[toChoose]);

	}

}
