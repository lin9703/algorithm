package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since Feb 3, 2021
 * @author lin9703
 * @problem SWEA 2805번 농작물 수확하기
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE&problemTitle=2805&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 1,400
 * @time 151
 * @caution 구현
 */
public class Problem2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			String[][] farm = new String[N][N];
			for (int i = 0; i < N; i++) {
				farm[i] = br.readLine().split("");
			}

			int profit = 0;
			int standard = N / 2;
			for (int i = 0; i <= N / 2; i++) {
				profit += Integer.parseInt(farm[i][standard]);
				for (int j = 1; j <= i; j++) {
					profit += Integer.parseInt(farm[i][standard - j]);
					profit += Integer.parseInt(farm[i][standard + j]);
				}
			}

			for (int i = N - 1; i > N / 2; i--) {
				profit += Integer.parseInt(farm[i][standard]);
				for (int j = 1; j <= (N - 1 - i); j++) {
					profit += Integer.parseInt(farm[i][standard - j]);
					profit += Integer.parseInt(farm[i][standard + j]);
				}
			}

			// print
			sb.append("#").append(t).append(" ").append(profit).append("\n");
		}

		System.out.println(sb);
	}

}
