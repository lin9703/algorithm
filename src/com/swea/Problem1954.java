package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 2, 2021
 * @author lin9703
 * @problem SWEA 1954번 달팽이 숫자
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=1954&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 18,148
 * @time 115
 * @caution 구현
 */
public class Problem1954 {
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int[][] snail = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(snail[i], 0);
			}

			int y = 0, x = 0, p = 0;
			for (int i = 1; i <= N * N; i++) {
				snail[y][x] = i;
				if (y + dy[p] < 0 || y + dy[p] >= N || x + dx[p] < 0 || x + dx[p] >= N
						|| snail[y + dy[p]][x + dx[p]] != 0) {
					p++;
					p %= 4;
				}

				y += dy[p];
				x += dx[p];
			}

			// print
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}
