package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 1194번 달이 차오른다, 가자.
https://www.acmicpc.net/problem/1194

- 풀이법: BFS + 3차원 visited 배열
  ㄴ time: 120 
*/
public class Problem1194 {
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		Queue<Point> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][128];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					q.add(new Point(i, j, 0, 0));
					visited[i][j][0] = true;
				}
			}
		}

		int min = -1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			int keys = p.keys;
			int dis = p.dis;

			for (int i = 0; i < 4; i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (!visited[nx][ny][keys]) {
					if (map[nx][ny] == '.' || map[nx][ny] == '0') {
						q.add(new Point(nx, ny, keys, dis + 1));
						visited[nx][ny][keys] = true;
					} else if (Character.isLowerCase(map[nx][ny])) {
						int temp = keys | 1 << (map[nx][ny] - 'a' + 1);
						q.add(new Point(nx, ny, temp, dis + 1));
						visited[nx][ny][temp] = true;
					} else if (Character.isUpperCase(map[nx][ny])) {
						if ((keys & 1 << Character.toLowerCase(map[nx][ny]) - 'a' + 1) != 0) {
							q.add(new Point(nx, ny, keys, dis + 1));
							visited[nx][ny][keys] = true;
						}
					} else if (map[nx][ny] == '1') {
						q.clear();
						min = dis + 1;
						break;
					}
				}
			}
		}

		System.out.println(min);

	}

	static class Point {
		int x;
		int y;
		int keys;
		int dis;

		public Point(int x, int y, int keys, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.dis = dis;
		}
	}

}
