package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
SWEA 2115. [모의 SW 역량테스트] 벌꿀채취
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu&categoryId=AV5V4A46AdIDFAWu&categoryType=CODE&problemTitle=2115&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&

- 풀이법: 구현 
  ㄴ time: 122
*/
public class Problem2115 {
	static int N, M, C;
	static int[][] honey;
	static int[][] profit;
	static int temp = 0;
	static int maxProfit = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			honey = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			profit = new int[N][N - M + 1];
			for (int r = 0; r < N; r++) {
				for (int i = 0; i < N - M + 1; i++) {
					temp = 0;
					getMaxProfit(r, i, i + M, 0, 0);
					profit[r][i] = temp;
				}
			}

			maxProfit = 0;
			// 행 내에서 최대값 구하기
			if (M <= N / 2) {
				for (int r = 0; r < N; r++) {
					getMaxSum(r, 0, 0, 0);
				}
			}

			// 열에서 최대값 구하기
			int[] max = new int[N];
			for (int r = 0; r < N; r++) {
				Arrays.sort(profit[r]);
				max[r] = profit[r][N - M];
			}
			Arrays.sort(max);
			maxProfit = Math.max(maxProfit, max[N - 1] + max[N - 2]);

			sb.append("#").append(t).append(" ").append(maxProfit).append("\n");
		}
		System.out.println(sb);
	}

	private static void getMaxSum(int row, int choose, int startIdx, int sum) {
		if (choose == 2) {
			maxProfit = Math.max(maxProfit, sum);
			return;
		}

		for (int i = startIdx; i < N - M + 1; i++) {
			if (choose == 1 && i < startIdx + M - 1)
				continue;

			getMaxSum(row, choose + 1, i + 1, sum + profit[row][i]);
		}
	}

	private static void getMaxProfit(int row, int index, int end, int sum, int profit) {
		if (sum > C)
			return;
		if (index == end) {
			temp = Math.max(temp, profit);
			return;
		}

		getMaxProfit(row, index + 1, end, sum + honey[row][index], (int) (profit + Math.pow(honey[row][index], 2)));
		getMaxProfit(row, index + 1, end, sum, profit);

	}

}
