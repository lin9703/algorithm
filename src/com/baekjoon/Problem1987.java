package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1987번 알파벳
https://www.acmicpc.net/problem/1987

- 풀이법: DFS 이용 
  ㄴ time: 880
*/
public class Problem1987 {
	static int r, c;
	static char[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int maxMove = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1 << (board[0][0] - 65), 1);

		System.out.println(maxMove);

	}

	private static void dfs(int x, int y, int flag, int count) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < r && nx >= 0 && ny < c && ny >= 0 
					&& (flag & 1 << (board[nx][ny] - 65)) == 0) {
				dfs(nx, ny, flag | 1 << (board[nx][ny] - 65), count + 1);
			} else {
				maxMove = Math.max(maxMove, count);
			}
		}
	}

}
