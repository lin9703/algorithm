package com.baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 16236번 아기 상어
https://www.acmicpc.net/problem/16236

- 풀이법: 구현 + BFS
  ㄴ 상어가 지나온 자리 0으로 초기화 하기 (맨 처음 위치한 자리 포함) 
  ㄴ time: 88
*/
public class Problem16236 {
	static int N;
	static int[][] map;
	static Fish shark;
	static int[][] deltas = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int minCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					shark = new Fish(2, i, j);
					map[i][j] = 0;
				}
			}
		}

		while (eatFish()) {
			shark.eat++;
			if (shark.eat == shark.size) {
				shark.eat = 0;
				shark.size++;
			}
		}

		System.out.println(minCount);
	}

	private static boolean eatFish() {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		List<Fish> fishes = new ArrayList<>();

		q.add(new Point(shark.x, shark.y));
		visited[shark.x][shark.y] = true;

		int count = 0;
		boolean find = false;
		while (!q.isEmpty() && !find) {
			count++;
			int size = q.size();

			while (size-- > 0) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;

				for (int i = 0; i < 4; i++) {
					int nx = x + deltas[i][0];
					int ny = y + deltas[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > shark.size)
						continue;
					if (map[nx][ny] == 0 || map[nx][ny] == shark.size) {
						q.add(new Point(nx, ny));
						visited[nx][ny] = true;
					} else if (map[nx][ny] < shark.size) {
						fishes.add(new Fish(map[nx][ny], nx, ny));
						visited[nx][ny] = true;
						find = true;
					}

				}
			}
		}

		if (!find)
			return false;

		Collections.sort(fishes);

		minCount += count;

		Fish first = fishes.get(0);
		map[first.x][first.y] = 0;
		shark.x = first.x;
		shark.y = first.y;

		return true;
	}

	static class Fish implements Comparable<Fish> {
		int eat;
		int size;
		int x;
		int y;

		public Fish(int size, int x, int y) {
			this.size = size;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.x == o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}

	}
}
