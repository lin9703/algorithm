package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 17143번 낚시왕
https://www.acmicpc.net/problem/17143

- 풀이법: 구현 
  ㄴ time: 1660 -> 432
  ㄴ speed를 R, C 길이에 따라 최적화 
*/
public class Problem17143 {
	static int R, C, M;
	static Shark[] sharks;
	static int[][] map;
	static int catchSize = 0;
	static int[][] deltas = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharks = new Shark[M + 1];
		map = new int[R + 1][C + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharks[i] = new Shark(r, c, s, d, z);
			map[r][c] = i;
		}

		for (int people = 1; people <= C; people++) {
			catchShark(people);

			moveSharks();
		}

		System.out.println(catchSize);

	}

	private static void moveSharks() {
		int[][] moveAfter = new int[R + 1][C + 1];
		for (int i = 1; i <= M; i++) {
			if (sharks[i] == null)
				continue;

			Shark shark = sharks[i];
			int nx = shark.r;
			int ny = shark.c;
			if (deltas[shark.dir][0] != 0) {
				int speed = shark.speed % (2 * (R - 1));
				for (int j = 1; j <= speed; j++) {
					if ((nx == 1 && shark.dir == 1) || (nx == R && shark.dir == 2)) {
						shark.changeDir();
					}
					nx += deltas[shark.dir][0];
				}
			} else {
				int speed = shark.speed % (2 * (C - 1));
				for (int j = 1; j <= speed; j++) {
					if ((ny == 1 && shark.dir == 4) || (ny == C && shark.dir == 3)) {
						shark.changeDir();
					}
					ny += deltas[shark.dir][1];
				}
			}

			shark.r = nx;
			shark.c = ny;
			if (moveAfter[nx][ny] != 0) {
				if (shark.size > sharks[moveAfter[nx][ny]].size) {
					sharks[moveAfter[nx][ny]] = null;
					moveAfter[nx][ny] = i;
				} else {
					sharks[i] = null;
				}
			} else {
				moveAfter[nx][ny] = i;
			}

		}

		map = moveAfter;

	}

	private static void catchShark(int people) {
		for (int i = 1; i <= R; i++) {
			if (map[i][people] != 0) {
				int index = map[i][people];
				catchSize += sharks[index].size;
				sharks[index] = null;
				map[i][people] = 0;
				return;
			}
		}

	}

	static class Shark {
		int r, c;
		int speed;
		int dir;
		int size;

		public Shark(int r, int c, int speed, int dir, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		public void changeDir() {
			if (dir == 1)
				dir = 2;
			else if (dir == 2)
				dir = 1;
			else if (dir == 3)
				dir = 4;
			else if (dir == 4)
				dir = 3;
		}

	}
}
