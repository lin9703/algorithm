package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since Feb 26, 2021
 * @author lin9703
 * @problem SWEA 5356번 의석이의 세로로 말해요
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO
 * @mem 23,736
 * @time 129
 * @caution 배열 사용
 */
public class Problem5356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			String[][] words = new String[5][];
			int maxLen = 0;
			for (int i = 0; i < 5; i++) {
				words[i] = br.readLine().split("");
				maxLen = Math.max(maxLen, words[i].length);
			}

			for (int i = 0; i < maxLen; i++) {
				for (int j = 0; j < 5; j++) {
					if (i < words[j].length)
						sb.append(words[j][i]);
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
}
