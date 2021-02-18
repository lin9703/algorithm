package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 3109번 빵집
https://www.acmicpc.net/problem/3109

- 풀이법: Greedy 알고리즘 - 재귀 이용 (시간초과)
  ㄴ 이미 갔던 길은 경로가 없어도 true 표시 -> 어차피 똑같이 실패하기 때문에 -> Backtracking 사용 (성공)
  ㄴ time: 476
*/
public class Problem3109 {
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int r, c;
	static char[][] map;
	static boolean[][] isVisited;
	static int pipes = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		isVisited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			Arrays.fill(isVisited[i], false);
		}

		for (int i = 0; i < r; i++) {
			getPipesNum(i, 1);
		}

		System.out.println(pipes);

	}

	private static boolean getPipesNum(int x, int y) {
		if (y == c - 1) {
			pipes++;
			return true;
		}

		if (map[x][y] == '.' && !isVisited[x][y]) {
			isVisited[x][y] = true;
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < r) {
					if (getPipesNum(nx, ny)) {
						return true;
					}
				}

			}
		}

		return false;
	}

}
