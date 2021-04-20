package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 14503번 로봇 청소기
https://www.acmicpc.net/problem/14503

- 풀이법: 구현
  ㄴ time: 84
*/
public class Problem14503 {
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북 동 남 서

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] robot = new int[3]; // r c d
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			robot[i] = Integer.parseInt(st.nextToken());
		}

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int clean = 0;
		int noclean = 0;
		int i = 0;
		while (true) {
			int x = robot[0];
			int y = robot[1];
			int d = robot[2];

			// 현재 위치 청소
			if (map[x][y] == 0) {
				map[x][y] = --i;
				clean++;
			}

			// b. 왼쪽으로 회전
			robot[2]--;
			if (robot[2] < 0) {
				robot[2] += 4;
			}

			// a. 왼쪽 청소 가능한지 확인
			x += deltas[robot[2]][0];
			y += deltas[robot[2]][1];
			if (map[x][y] == 0) {
				robot[0] = x;
				robot[1] = y;

				noclean = 0;
				continue;
			}

			if (++noclean == 4) {
				noclean = 0;

				robot[0] -= deltas[robot[2]][0];
				robot[1] -= deltas[robot[2]][1];

				if (map[robot[0]][robot[1]] == 1) {
					break;
				}
			}

		}

		System.out.println(clean);
	}
}
