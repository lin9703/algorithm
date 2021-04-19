package com.baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 15683번 감시
https://www.acmicpc.net/problem/15683

- 풀이법: 구현 
  ㄴ time: 132
*/
public class Problem15683 {
	static int N, M;
	static int[][] map;
	static int square;
	static int minSquare = Integer.MAX_VALUE;
	static List<Point> cctvs;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][][] see = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 1 }, { 2, 3 } },
			{ { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }, { { 1, 2, 3 }, { 0, 2, 3 }, { 0, 1, 3 }, { 0, 1, 2 } },
			{ { 0, 1, 2, 3 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		square = 0;
		cctvs = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctvs.add(new Point(i, j));
				} else if (map[i][j] == 0) {
					square++;
				}
			}
		}

		getMinSquare(0);

		System.out.println(minSquare);

	}

	private static void getMinSquare(int n) {
		if (n == cctvs.size()) {
			minSquare = Math.min(minSquare, square);
			return;
		}

		Point cctv = cctvs.get(n);
		int x = cctv.x;
		int y = cctv.y;
		int[][] cctvSee = see[map[x][y]];

		for (int j = 0; j < cctvSee.length; j++) {
			makeCCTV(x, y, cctvSee[j]);
			getMinSquare(n + 1);
			deleteCCTV(x, y, cctvSee[j]);
		}
	}

	private static void deleteCCTV(int x, int y, int[] cctvSee) {
		for (int i = 0; i < cctvSee.length; i++) {
			int nx = x + deltas[cctvSee[i]][0];
			int ny = y + deltas[cctvSee[i]][1];

			while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (map[nx][ny] == 6) {
					break;
				} else if (map[nx][ny] < 0) {
					map[nx][ny]++;

					if (map[nx][ny] == 0) {
						square++;
					}
				}

				nx += deltas[cctvSee[i]][0];
				ny += deltas[cctvSee[i]][1];
			}
		}
	}

	private static void makeCCTV(int x, int y, int[] cctvSee) {
		for (int i = 0; i < cctvSee.length; i++) {
			int nx = x + deltas[cctvSee[i]][0];
			int ny = y + deltas[cctvSee[i]][1];

			while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (map[nx][ny] == 6) {
					break;
				} else if (map[nx][ny] == 0) {
					square--;
					map[nx][ny]--;
				} else if (map[nx][ny] < 0) {
					map[nx][ny]--;
				}

				nx += deltas[cctvSee[i]][0];
				ny += deltas[cctvSee[i]][1];
			}
		}

	}

}
