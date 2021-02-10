package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 17406번 배열 돌리기 4
https://www.acmicpc.net/problem/17406

- 풀이법: 배열을 이용한 구현 
  ㄴ time: 300
*/
public class Problem17406 {
	static int N, M;
	static Command[] commands;
	static int[][] array;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// array 저장
		array = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 명령 저장
		commands = new Command[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			commands[i] = new Command(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		// 순열로 명령 뽑기
		permutation(K, new Command[K], new boolean[K]);

		System.out.println(result);
	}

	static class Command {
		int r;
		int c;
		int s;

		public Command(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}

	private static void permutation(int toChoose, Command[] chosen, boolean[] visited) {
		if (toChoose == 0) {
			int[][] temp = new int[N + 1][M + 1];

			for (int i = 1; i < N + 1; i++) {
				temp[i] = Arrays.copyOf(array[i], M + 1);
			}

			for (Command c : chosen) {
				rotate(temp, c.r, c.c, c.s);
			}

			getMinRow(temp);
			return;
		}

		for (int i = 0; i < commands.length; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			chosen[commands.length - toChoose] = commands[i];
			permutation(toChoose - 1, chosen, visited);
			visited[i] = false;
		}
	}

	private static void getMinRow(int[][] temp) {
		for (int i = 1; i < N + 1; i++) {
			int sum = 0;
			for (int j = 1; j < M + 1; j++) {
				sum += temp[i][j];
				if (sum > result) {
					break;
				}
			}
			result = Math.min(result, sum);
		}
	}

	private static void rotate(int[][] arr, int r, int c, int s) {
		int startX = r - s;
		int startY = c - s;
		int endX = r + s;
		int endY = c + s;

		for (int n = 0; n < s; n++) {
			int temp = arr[startX][endY];
			for (int i = endY - 1; i >= startY; i--) {
				arr[startX][i + 1] = arr[startX][i];
			}
			for (int i = startX + 1; i <= endX; i++) {
				arr[i - 1][startY] = arr[i][startY];
			}
			for (int i = startY + 1; i <= endY; i++) {
				arr[endX][i - 1] = arr[endX][i];
			}
			for (int i = endX - 1; i >= startX + 1; i--) {
				arr[i + 1][endY] = arr[i][endY];
			}

			arr[startX + 1][endY] = temp;

			startX++;
			startY++;
			endX--;
			endY--;

		}
	}

}
