package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 19, 2021
 * @author lin9703
 * @problem SWEA 4012번 요리사
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&categoryId=AWIeUtVakTMDFAVH&categoryType=CODE&problemTitle=4012&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 47,012
 * @time 216
 * @caution 조합 2개 사용 + 구현
 */
public class Problem4012 {
	static int N;
	static int[][] S;
	static int minDiff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minDiff = Integer.MAX_VALUE;
			combination(0, 0, 0);

			sb.append("#").append(t).append(" ").append(minDiff).append("\n");
		}

		System.out.println(sb);
	}

	private static void combination(int toChoose, int flag, int startIdx) {
		if (toChoose == N / 2) {
			minDiff = Math.min(minDiff, getDiff(flag));
			return;
		}

		for (int i = startIdx; i < N; i++) {
			combination(toChoose + 1, flag | 1 << i, i + 1);
		}
	}

	private static int getDiff(int flag) {
		int[] group1 = new int[N / 2];
		int[] group2 = new int[N / 2];

		int idx1 = 0;
		int idx2 = 0;
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				group1[idx1++] = i;
			} else {
				group2[idx2++] = i;
			}
		}

		return Math.abs(getSynergy(group1, 0, new int[2], 0) - getSynergy(group2, 0, new int[2], 0));
	}

	private static int getSynergy(int[] group, int toChoose, int[] chosen, int startIdx) {
		if (toChoose == 2) {
			return S[chosen[0]][chosen[1]] + S[chosen[1]][chosen[0]];
		}

		int sum = 0;
		for (int i = startIdx; i < group.length; i++) {
			chosen[toChoose] = group[i];
			sum += getSynergy(group, toChoose + 1, chosen, i + 1);
		}

		return sum;
	}
}
