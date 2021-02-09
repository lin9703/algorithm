package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since Feb 9, 2021
 * @author lin9703
 * @problem SWEA 1233번 사칙연산 유효성 검사
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD&categoryId=AV141176AIwCFAYD&categoryType=CODE&problemTitle=1233&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 18,824
 * @time 104
 * @caution hasMoreTokens() 이용
 */
public class Problem1233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			int result = 1;
			boolean isTrue = true;
			for (int i = 0; i < N; i++) {
				if (isTrue) {
					st = new StringTokenizer(br.readLine());
					st.nextToken();
					String s = st.nextToken();

					if (st.hasMoreTokens()) {
						if (!operator.contains(s)) {
							result = 0;
							isTrue = false;
						}
					} else {
						if (operator.contains(s)) {
							result = 0;
							isTrue = false;
						}
					}
				} else {
					br.readLine();
				}
			}

			// print
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

}
