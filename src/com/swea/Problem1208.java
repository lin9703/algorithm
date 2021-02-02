package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 2, 2021
 * @author lin9703
 * @problem SWEA 1208번 Flatten
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=1208&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 21,428
 * @time 123
 * @caution Arrays.sort() 이용
 */
public class Problem1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int dumpNum = Integer.parseInt(st.nextToken());

			int[] boxes = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 100; j++) {
				boxes[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < dumpNum; j++) {
				Arrays.sort(boxes);

				if (boxes[99] - boxes[0] <= 1) {
					break;
				}

				boxes[0]++;
				boxes[99]--;
			}

			Arrays.sort(boxes);
			int result = boxes[99] - boxes[0];

			sb.append("#").append(i).append(" ").append(result).append("\n");

		}

		System.out.println(sb);

	}
}
