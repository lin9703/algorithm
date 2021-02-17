package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
백준 17413번 단어 뒤집기 2
https://www.acmicpc.net/problem/17413

- 풀이법: Stack 이용 
  ㄴ time: 272
*/
public class Problem17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);

			if (c == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}

				do {
					sb.append(c);
				} while ((c = S.charAt(++i)) != '>');
				sb.append(c);
			} else if (c == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
			} else {
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}

}
