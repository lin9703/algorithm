package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 2636번 치즈
https://www.acmicpc.net/problem/2636

- 풀이법: BFS 사용 
  ㄴ time: 104
*/
public class Problem2636 {
	static int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] plate = new int[r][c];
		boolean[][] visited = new boolean[r][c];
		Queue<Point> airs = new ArrayDeque<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());

				if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
					airs.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}

		Queue<Point> cheeses = new ArrayDeque<>();
		int cnt = 0;
		int size = 0;
		while (true) {
			while (!airs.isEmpty()) {
				Point air = airs.poll();

				int x = air.x;
				int y = air.y;
				for (int i = 0; i < 4; i++) {
					int nx = x + deltas[i][0];
					int ny = y + deltas[i][1];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (plate[nx][ny] == 0 && !visited[nx][ny]) {
						airs.add(new Point(nx, ny));
						visited[nx][ny] = true;
					} else if (plate[nx][ny] == 1 && !visited[nx][ny]) {
						cheeses.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}

			}

			if (cheeses.isEmpty())
				break;

			size = cheeses.size();
			cnt++;
			while (!cheeses.isEmpty()) {
				Point cheese = cheeses.poll();

				int x = cheese.x;
				int y = cheese.y;

				airs.add(new Point(x, y));
			}

		}

		System.out.println(cnt + "\n" + size);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
