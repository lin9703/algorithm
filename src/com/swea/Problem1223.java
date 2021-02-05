package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since Feb 5, 2021
 * @author lin9703
 * @problem SWEA 1223번 6일차 - 계산기2
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD&categoryId=AV14nnAaAFACFAYD&categoryType=CODE&problemTitle=1223&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 19,716
 * @time 113
 * @caution Stack 2개 사용 (1. 후위 표기식으로 바꾸어 계산 / 2. 후위 표기식 계산)
 */
public class Problem1223 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String formula = st.nextToken();

			// 후위 표기식으로 변환
			Stack<Character> operator = new Stack<>();
			StringBuilder backward = new StringBuilder();
			for (int i = 0; i < len; i++) {
				char c = formula.charAt(i);

				if (c >= '0' && c <= '9') {
					backward.append(c);
				} else if (c == '+') {
					while (!operator.isEmpty()) {
						backward.append(operator.pop());
					}
					operator.add(c);
				} else if (c == '*') {
					operator.add(c);
				}
			}
			while (!operator.isEmpty()) {
				backward.append(operator.pop());
			}

			// 후위 표기식 계산
			Stack<Integer> number = new Stack<>();
			for (int i = 0; i < len; i++) {
				char c = backward.charAt(i);

				if (c >= '0' && c <= '9') {
					number.add(Integer.parseInt(String.valueOf(c)));
				} else if (c == '+') {
					number.add(number.pop() + number.pop());
				} else if (c == '*') {
					number.add(number.pop() * number.pop());
				}
			}

			sb.append("#").append(t).append(" ").append(number.pop()).append("\n");
		}

		System.out.println(sb);
	}

}
