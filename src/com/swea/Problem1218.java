package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since Feb 4, 2021
 * @author lin9703
 * @problem SWEA 1218번 괄호 짝짓기
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=1218&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 18,668
 * @time 101
 * @caution Stack 이용 - 괄호 문제
 */
public class Problem1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			Stack<Character> stack = new Stack<>();
			int result = 0;
			for (int i = 0; i < N; i++) {
				char temp = s.charAt(i);
				if (temp == '(' || temp == '[' || temp == '{' || temp == '<') {
					stack.add(temp);
				} else if (temp == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else
						break;
				} else if (temp == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else
						break;
				} else if (temp == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else
						break;
				} else if (temp == '>') {
					if (stack.peek() == '<') {
						stack.pop();
					} else
						break;
				}

				if (i == N - 1) {
					result = 1;
				}
			}

			// print
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

}
