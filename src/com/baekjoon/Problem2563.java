package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 9, 2021
 * @author lin9703
 * @problem 백준 2563번 색종이
 * @see https://www.acmicpc.net/problem/2563
 * @mem 14496
 * @time 128
 * @caution boolean[][] 배열 이용 
 */
public class Problem2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		boolean[][] white = new boolean[101][101];
		for (int i = 0; i < white.length; i++) {
			Arrays.fill(white[i], false);
		}
		int result = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (!white[i][j]) {
						white[i][j] = true;
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}
}
