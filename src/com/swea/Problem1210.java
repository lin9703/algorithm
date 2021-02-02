package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 2, 2021
 * @author lin9703
 * @problem SWEA 1210번 Ladder1
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE&problemTitle=1210&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 31,164
 * @time 154
 * @caution 구현
 */
public class Problem1210 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int[][] ladder = new int[100][100];
			int arrival = -1;
			for (int i = 0; i < ladder.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < ladder[i].length; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());

					if (i == 99 && ladder[i][j] == 2) {
						arrival = j;
					}
				}
			}

			int j = arrival;
			for (int i = 98; i >= 0; i--) {
				if (j - 1 >= 0 && ladder[i][j - 1] == 1) {
					while (j - 1 >= 0 && ladder[i][j - 1] == 1) {
						j--;
					}
				} else if (j + 1 <= 99 && ladder[i][j + 1] == 1) {
					while (j + 1 <= 99 && ladder[i][j + 1] == 1) {
						j++;
					}
				}
			}

			int result = j;
			sb.append("#").append(t).append(" ").append(result).append("\n");

		}

		System.out.println(sb);
	}
}
