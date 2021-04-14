package com.swea;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
SWEA 1953번 탈주범 검거
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq&categoryId=AV5PpLlKAQ4DFAUq&categoryType=CODE&problemTitle=1953&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

- 풀이법: BFS + 구현  
  ㄴ time: 146
*/
public class Problem1953 {
	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] tunnel = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visited = new boolean[N][M];
			Queue<Point> q = new ArrayDeque<>();
			q.add(new Point(R, C));
			visited[R][C] = true;
			int time = 1;
			int count = 1;

			while (time < L && !q.isEmpty()) {
				int size = q.size();
				time++;

				while (size-- > 0) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					int num = map[x][y];

					if (num > 0) {
						for (int i = 0; i < tunnel[num].length; i++) {
							int nx = x + deltas[tunnel[num][i]][0];
							int ny = y + deltas[tunnel[num][i]][1];

							if (nx < 0 || ny < 0 || nx >= N || ny >= M)
								continue;
							if (!visited[nx][ny] && moveCheck(nx, ny, tunnel[num][i])) {
								count++;
								visited[nx][ny] = true;
								q.add(new Point(nx, ny));
							}
						}
					}
				}
			}

			sb.append("#").append(t).append(" ").append(count).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean moveCheck(int nx, int ny, int i) {
		int other = -1;
		if (i == 0)
			other = 1;
		else if (i == 1)
			other = 0;
		else if (i == 2)
			other = 3;
		else if (i == 3)
			other = 2;

		int[] has = tunnel[map[nx][ny]];
		for (int j = 0; j < has.length; j++) {
			if (has[j] == other)
				return true;
		}
		return false;
	}
}
