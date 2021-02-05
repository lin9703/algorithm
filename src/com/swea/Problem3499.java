package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 5, 2021
 * @author lin9703
 * @problem SWEA 3499번 퍼펙트 셔플
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE&problemTitle=3499&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 24,644
 * @time 114
 * @caution
 */
public class Problem3499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			String[] cards = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}

			int half = N / 2;
			if (N % 2 == 1)
				half++;

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < N / 2; i++) {
				sb.append(cards[i]).append(" ");
				sb.append(cards[half + i]).append(" ");
			}
			if (N % 2 == 1) {
				sb.append(cards[half - 1]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
