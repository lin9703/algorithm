package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Mar 20, 2021
 * @author lin9703
 * @problem SWEA 3307번 최장 증가 부분 수열
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE&problemTitle=3307&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 25,248
 * @time 148
 * @caution LIS: 현재 idx의 앞의 값들과 비교해서 dp값 저장 (O(n^2))
 */
public class Problem3307 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int T = Integer.parseInt(input.readLine());
		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(input.readLine());

			int[] nums = new int[N];
			tokenizer = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(tokenizer.nextToken());
			}

			int[] lis = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i]) {
						lis[i] = Math.max(lis[i], lis[j] + 1);
					}
				}
				max = Math.max(max, lis[i]);
			}

			ans.append("#").append(t).append(" ").append(max).append("\n");
		}

		System.out.println(ans);
	}
}
