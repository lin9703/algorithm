package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 19236번 청소년 상어
https://www.acmicpc.net/problem/19236

- 풀이법: 구현 
  ㄴ time: 80
*/
public class Problem19236 {
	static int[][] deltas = { {}, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, 
			{ 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 } };
	static int maxSum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Fish[][] fishes = new Fish[4][4];
		Fish[] fishList = new Fish[17];
		fishList[0] = new Fish(0, 0, 0, 0);
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				fishes[i][j] = new Fish(i, j, a, b);
				fishList[(i * 4) + j + 1] = fishes[i][j];
			}
		}

		Arrays.sort(fishList);

		Fish shark = new Fish(0, 0, 0, 0);
		getMaxSum(shark, fishes, fishList, 0, 0, 0);

		System.out.println(maxSum);
	}

	private static void getMaxSum(Fish shark, Fish[][] fishes, Fish[] fishList, int x, int y, int sum) {
		eatFish(shark, fishes[x][y]);
		sum += fishes[x][y].num;
		fishList[fishes[x][y].num] = null;
		fishes[x][y] = null;

		moveFishes(fishList, fishes, shark);

		int nx = shark.x;
		int ny = shark.y;

		int count = 0;
		while (true) {
			nx += deltas[shark.dir][0];
			ny += deltas[shark.dir][1];
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)
				break;
			if (fishes[nx][ny] == null)
				continue;

			count++;
			Fish[][] copy = copyArray2(fishes);
			getMaxSum(new Fish(shark), copy, copyArray(fishList, copy), nx, ny, sum);
		}

		if (count == 0) {
			maxSum = Math.max(maxSum, sum);
			return;
		}

	}

	private static Fish[] copyArray(Fish[] fishList, Fish[][] fishes) {
		Fish[] copy = new Fish[17];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (fishes[i][j] == null)
					continue;

				copy[fishes[i][j].num] = fishes[i][j];
			}
		}
		return copy;
	}

	private static Fish[][] copyArray2(Fish[][] fishes) {
		Fish[][] copy = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (fishes[i][j] == null)
					continue;

				copy[i][j] = new Fish(fishes[i][j]);
			}
		}
		return copy;
	}

	private static void moveFishes(Fish[] fishList, Fish[][] fishes, Fish shark) {
		for (int i = 1; i <= 16; i++) {
			Fish fish = fishList[i];
			if (fish == null)
				continue;

			int x = fish.x;
			int y = fish.y;
			int dir = fish.dir;

			int move = 0;
			int nx = -1, ny = -1;
			while (++move < 8) {
				nx = x + deltas[dir][0];
				ny = y + deltas[dir][1];

				if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (nx == shark.x && ny == shark.y)) {
					fish.changeDir();
					dir = fish.dir;
				} else {
					break;
				}
			}

			if (move == 8)
				continue;

			// swap
			if (fishes[nx][ny] != null) {
				fishes[nx][ny].changeLoc(x, y);
			}

			fishes[x][y].changeLoc(nx, ny);
			fishes[x][y] = fishes[nx][ny];
			fishes[nx][ny] = fish;
		}

	}

	private static void eatFish(Fish shark, Fish fish) {
		shark.x = fish.x;
		shark.y = fish.y;
		shark.dir = fish.dir;
	}

	static class Fish implements Comparable<Fish> {
		int x, y;
		int num;
		int dir;

		public Fish(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

		public Fish(Fish fish) {
			this.x = fish.x;
			this.y = fish.y;
			this.num = fish.num;
			this.dir = fish.dir;
		}

		public void changeDir() {
			dir++;
			if (dir > 8) {
				dir -= 8;
			}
		}

		public void changeLoc(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Fish o) {
			return Integer.compare(this.num, o.num);
		}

	}
}
