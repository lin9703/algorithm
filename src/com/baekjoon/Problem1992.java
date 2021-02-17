package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1992번 쿼드트리 
https://www.acmicpc.net/problem/1992

- 풀이법: 재귀 이용 (실패)
  ㄴ 압축할 때, piece가 "0" 또는 "1"이어야 한다는 조건 추가 
  ㄴ time: 140
*/
public class Problem1992 {
	static char[][] video;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		video = new char[N][N];
		for (int i = 0; i < N; i++) {
			video[i] = br.readLine().toCharArray();
		}

		System.out.println(quadTree(0, 0, N));
	}

	private static String quadTree(int startX, int startY, int len) {
		if (len == 1) {
			if (video[startX][startY] == '1')
				return "1";
			else
				return "0";
		}

		int half = len / 2;
		String[] pieces = new String[4];
		pieces[0] = quadTree(startX, startY, half);
		pieces[1] = quadTree(startX, startY + half, half);
		pieces[2] = quadTree(startX + half, startY, half);
		pieces[3] = quadTree(startX + half, startY + half, half);

		int count = 1;
		if (pieces[0].equals("0") || pieces[0].equals("1")) {
			while (count < 4 && pieces[0].equals(pieces[count]))
				count++;
		}

		if (count == 4) {
			return pieces[0];
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			for (String s : pieces) {
				sb.append(s);
			}
			sb.append(")");

			return sb.toString();
		}

	}

}
