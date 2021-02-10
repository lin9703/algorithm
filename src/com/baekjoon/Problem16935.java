package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 16935번 배열 돌리기 3
https://www.acmicpc.net/problem/16935

- 풀이법: 배열을 이용한 구현 
  ㄴ time: 564
*/
public class Problem16935 {
	static int N, M;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		// array 저장
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int r = Integer.parseInt(st.nextToken());
			switch (r) {
			case 1:
				array = upsideReversal();
				break;
			case 2:
				array = leftRightReversal();
				break;
			case 3:
				array = rotateToRight();
				swapNM();
				break;
			case 4:
				array = rotateToLeft();
				swapNM();
				break;
			case 5:
				array = moveByOrder();
				break;
			case 6:
				array = moveByReverse();
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void swapNM() {
		int temp = N;
		N = M;
		M = temp;
	}

	private static int[][] upsideReversal() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = array[N - 1 - i][j];
			}
		}

		return temp;
	}

	private static int[][] leftRightReversal() {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = array[i][M - 1 - j];
			}
		}

		return temp;
	}

	private static int[][] rotateToRight() {
		int[][] temp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[N - 1 - j][i];
			}
		}

		return temp;
	}

	private static int[][] rotateToLeft() {
		int[][] temp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[j][M - 1 - i];
			}
		}

		return temp;
	}

	private static int[][] moveByOrder() {
		int[][] temp = new int[N][M];
		int halfN = N / 2;
		int halfM = M / 2;

		for (int i = 0; i < halfN; i++) {
			for (int j = 0; j < halfM; j++) {
				temp[i][j + halfM] = array[i][j];
			}
		}
		for (int i = 0; i < halfN; i++) {
			for (int j = halfM; j < M; j++) {
				temp[i + halfN][j] = array[i][j];
			}
		}
		for (int i = halfN; i < N; i++) {
			for (int j = halfM; j < M; j++) {
				temp[i][j - halfM] = array[i][j];
			}
		}
		for (int i = halfN; i < N; i++) {
			for (int j = 0; j < halfM; j++) {
				temp[i - halfN][j] = array[i][j];
			}
		}

		return temp;
	}

	private static int[][] moveByReverse() {
		int[][] temp = new int[N][M];
		int halfN = N / 2;
		int halfM = M / 2;

		for (int i = 0; i < halfN; i++) {
			for (int j = 0; j < halfM; j++) {
				temp[i + halfN][j] = array[i][j];
			}
		}
		for (int i = 0; i < halfN; i++) {
			for (int j = halfM; j < M; j++) {
				temp[i][j - halfM] = array[i][j];
			}
		}
		for (int i = halfN; i < N; i++) {
			for (int j = halfM; j < M; j++) {
				temp[i - halfN][j] = array[i][j];
			}
		}
		for (int i = halfN; i < N; i++) {
			for (int j = 0; j < halfM; j++) {
				temp[i][j + halfM] = array[i][j];
			}
		}

		return temp;
	}

}
