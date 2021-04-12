package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 17144번 미세먼지 안녕!
https://www.acmicpc.net/problem/17144

- 풀이법: BFS + 구현 
  ㄴ time: 508
*/
public class Problem17144 {
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(input.readLine());

		int R = Integer.parseInt(tokenizer.nextToken());
		int C = Integer.parseInt(tokenizer.nextToken());
		int T = Integer.parseInt(tokenizer.nextToken());

		int[][] map = new int[R][C];

		int pivot = 0;
		Queue<Dust> dusts = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			tokenizer = new StringTokenizer(input.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (map[i][j] == -1) {
					pivot = i;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			// 미세먼지 체크
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						dusts.add(new Dust(i, j, map[i][j]));
					}
				}
			}

			// 미세먼지 확산
			while (!dusts.isEmpty()) {
				Dust dust = dusts.poll();
				int x = dust.r;
				int y = dust.c;
				int value = dust.value / 5;

				if (value > 0) {
					for (int i = 0; i < 4; i++) {
						int nx = x + deltas[i][0];
						int ny = y + deltas[i][1];

						if (nx < 0 || ny < 0 || nx >= R || ny >= C)
							continue;
						if (map[nx][ny] != -1) {
							map[x][y] -= value;
							map[nx][ny] += value;
						}
					}
				}

			}

			// 공기청정기 작동
			// 첫 번째 (pivot - 1)
			for (int i = pivot - 3; i >= 0; i--) {
				map[i + 1][0] = map[i][0];
			}
			for (int i = 1; i < C; i++) {
				map[0][i - 1] = map[0][i];
			}
			for (int i = 1; i <= pivot - 1; i++) {
				map[i - 1][C - 1] = map[i][C - 1];
			}
			for (int i = C - 2; i > 0; i--) {
				map[pivot - 1][i + 1] = map[pivot - 1][i];
			}
			map[pivot - 1][1] = 0;

			// 두 번째 (pivot)
			for (int i = pivot + 2; i < R; i++) {
				map[i - 1][0] = map[i][0];
			}
			for (int i = 1; i < C; i++) {
				map[R - 1][i - 1] = map[R - 1][i];
			}
			for (int i = R - 2; i >= pivot; i--) {
				map[i + 1][C - 1] = map[i][C - 1];
			}
			for (int i = C - 2; i > 0; i--) {
				map[pivot][i + 1] = map[pivot][i];
			}
			map[pivot][1] = 0;

		}

		int dustSum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					dustSum += map[i][j];
				}
			}
		}

		System.out.println(dustSum);

	}

	static class Dust {
		int r;
		int c;
		int value;

		public Dust(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}

	}

}
