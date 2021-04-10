package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 7569번 토마토
https://www.acmicpc.net/problem/7569

- 풀이법: BFS (3차원 배열)
  ㄴ time: 640	
*/
public class Problem7569 {
	static int M, N, H;
	static int[][] deltas = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		Queue<Location> queue = new ArrayDeque<>();
		int[][][] tomatoes = new int[H][N][M];
		int zeroCount = 0;
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomatoes[h][n][m] = Integer.parseInt(st.nextToken());

					if (tomatoes[h][n][m] == 1) {
						queue.add(new Location(h, n, m));
					} else if (tomatoes[h][n][m] == 0) {
						zeroCount++;
					}
				}
			}
		}

		int day = -1;
		while (!queue.isEmpty()) {
			day++;
			int size = queue.size();

			while (size-- > 0) {
				Location loc = queue.poll();
				int h = loc.h;
				int n = loc.n;
				int m = loc.m;

				for (int i = 0; i < deltas.length; i++) {
					int nh = h + deltas[i][0];
					int nn = n + deltas[i][1];
					int nm = m + deltas[i][2];

					if (nh < 0 || nn < 0 || nm < 0 || nh >= H || nn >= N || nm >= M)
						continue;
					if (tomatoes[nh][nn][nm] == 0) {
						tomatoes[nh][nn][nm] = 1;
						zeroCount--;
						queue.add(new Location(nh, nn, nm));
					}
				}
			}
		}

		if (zeroCount != 0) {
			day = -1;
		}

		System.out.println(day);

	}

	static class Location {
		int h;
		int n;
		int m;

		public Location(int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}

}
