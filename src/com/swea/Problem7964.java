package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 25, 2021
 * @author lin9703
 * @problem SWEA 7964번 부먹왕국의 차원 관문
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWuSgKpqmooDFASy&categoryId=AWuSgKpqmooDFASy&categoryType=CODE&problemTitle=7964&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 * @mem 72,144
 * @time 228
 * @caution 구현
 */
public class Problem7964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			int[] cities = new int[N + 1];
			cities[0] = 1;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				cities[i] = Integer.parseInt(st.nextToken());
			}

			int minDoors = 0;
			int cnt = 0;
			for (int i = 0; i < N + 1; i++) {
				if (cities[i] == 1)
					cnt = 0;

				if (cnt == D) {
					minDoors++;
					cnt = 0;
				}

				cnt++;
			}

			ans.append("#").append(t).append(" ").append(minDoors).append("\n");
		}

		System.out.println(ans);
	}

}
