package com.swea;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
SWEA 5656번 벽돌 깨기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo&categoryId=AWXRQm6qfL0DFAUo&categoryType=CODE&problemTitle=5656&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

- 풀이법: 구현 
  ㄴ time: 287
*/
public class Problem5656 {
	static int N, W, H;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int minCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] blocks = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					blocks[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minCount = Integer.MAX_VALUE;
			selectBlock(blocks, 0);

			answer.append("#").append(t).append(" ").append(minCount).append("\n");
		}

		System.out.println(answer);
	}

	private static void selectBlock(int[][] blocks, int choose) {
		if (choose == N) {
			minCount = Math.min(minCount, countBlocks(blocks));
			return;
		}

		for (int i = 0; i < W; i++) {
			int[][] newBlocks = eraseBlocks(blocks, i);
			selectBlock(newBlocks, choose + 1);
		}
	}

	private static int countBlocks(int[][] blocks) {
		int count = 0;

		for (int j = 0; j < W; j++) {
			int x = H;
			while (--x >= 0 && blocks[x][j] != 0) {
				count++;
			}
		}

		return count;
	}

	private static int[][] eraseBlocks(int[][] blocks, int deleteIdx) {
		int[][] newBlocks = new int[H][W];
		boolean[][] isDelete = new boolean[H][W];

		int xvalue = -1;
		for (int i = 0; i < H; i++) {
			if (blocks[i][deleteIdx] != 0) {
				xvalue = i;
				break;
			}
		}

		if (xvalue == -1) {
			return blocks;
		}

		Queue<Point> q = new ArrayDeque<>();
		isDelete[xvalue][deleteIdx] = true;
		q.add(new Point(xvalue, deleteIdx));

		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;

			if (blocks[x][y] > 1) {
				for (int i = 0; i < 4; i++) {
					int nx = x;
					int ny = y;
					for (int j = 1; j < blocks[x][y]; j++) {
						nx += deltas[i][0];
						ny += deltas[i][1];

						if (nx < 0 || ny < 0 || nx >= H || ny >= W)
							continue;
						if (!isDelete[nx][ny]) {
							isDelete[nx][ny] = true;
							if (blocks[nx][ny] > 1) {
								q.add(new Point(nx, ny));
							}
						}
					}
				}
			}

		}

		for (int j = 0; j < W; j++) {
			int available = H;
			int x = H;
			while (--x >= 0 && blocks[x][j] != 0) {
				if (!isDelete[x][j]) {
					newBlocks[--available][j] = blocks[x][j];
				}
			}
		}

		return newBlocks;
	}
}
