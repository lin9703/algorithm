package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since Feb 4, 2021
 * @author lin9703
 * @problem 백준 2493번 탑
 * @see https://www.acmicpc.net/problem/2493
 * @mem 85780
 * @time 752
 * @caution Stack 사용
 */
public class Problem2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		Stack<Top> availableTops = new Stack<>();

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			int result = 0;

			Top top = new Top(i, Integer.parseInt(st.nextToken()));

			while (!availableTops.isEmpty()) {
				Top temp = availableTops.pop();
				if (temp.height >= top.height) {
					result = temp.index;
					availableTops.push(temp);
					break;
				}
			}
			availableTops.push(top);

			sb.append(result).append(" ");
		}

		System.out.println(sb);
	}

	static class Top {
		int index;
		int height;

		public Top(int index, int height) {
			this.index = index;
			this.height = height;
		}
		
	}

}
