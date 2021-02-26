package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since Feb 26, 2021
 * @author lin9703
 * @problem SWEA 4789번 성공적인 공연 기획
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWS2dSgKA8MDFAVT&categoryId=AWS2dSgKA8MDFAVT&categoryType=CODE&problemTitle=4789&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 23,736
 * @time 129
 * @caution 배열 사용
 */
public class Problem4789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split("");

			int cnt = 0;
			int need = 0;
			for (int i = 0; i < s.length; i++) {
				int num = Integer.parseInt(s[i]);

				if (num != 0 && cnt < i) {
					need += i - cnt;
					cnt = i;
				}

				cnt += num;
			}

			sb.append("#").append(t).append(" ");
			sb.append(need).append("\n");
		}

		System.out.println(sb);
	}
}
