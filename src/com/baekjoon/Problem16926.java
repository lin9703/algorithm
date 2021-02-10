package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 16926번 배열 돌리기 1
https://www.acmicpc.net/problem/16926

- 풀이법: 처음 실패 -> halfN을 M과 N의 최솟값 /2로 변경해서 패스 
  ㄴ time: 584
*/
public class Problem16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] array = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int halfN = Math.min(M, N) / 2;
		List<LinkedList<Point>> list = new ArrayList<>(halfN);
		for (int i = 0; i < halfN; i++) {
			list.add(new LinkedList<Point>());
		}

		for (int n = 0; n < halfN; n++) {
			for (int i = n + 1; i <= M - n; i++) {
				list.get(n).add(new Point(n + 1, i));
			}
			for (int i = n + 2; i <= N - n; i++) {
				list.get(n).add(new Point(i, M - n));
			}
			for (int i = M - n - 1; i >= n + 1; i--) {
				list.get(n).add(new Point(N - n, i));
			}
			for (int i = N - n - 1; i > n + 1; i--) {
				list.get(n).add(new Point(i, n + 1));
			}

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < halfN; j++) {
				list.get(j).addLast(list.get(j).pollFirst());
			}
		}

		int[][] result = new int[N + 1][M + 1];
		for (int n = 0; n < halfN; n++) {
			for (int i = n + 1; i <= M - n; i++) {
				Point p = list.get(n).pollFirst();
				result[n + 1][i] = array[p.x][p.y];
			}
			for (int i = n + 2; i <= N - n; i++) {
				Point p = list.get(n).pollFirst();
				result[i][M - n] = array[p.x][p.y];
			}
			for (int i = M - n - 1; i >= n + 1; i--) {
				Point p = list.get(n).pollFirst();
				result[N - n][i] = array[p.x][p.y];
			}
			for (int i = N - n - 1; i > n + 1; i--) {
				Point p = list.get(n).pollFirst();
				result[i][n + 1] = array[p.x][p.y];
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
