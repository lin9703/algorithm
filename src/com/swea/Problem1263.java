package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Mar 21, 2021
 * @author lin9703
 * @problem SWEA 1263번 사람 네트워크2
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN&categoryId=AV18P2B6Iu8CFAZN&categoryType=CODE&problemTitle=1263&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 96,916
 * @time 3,396
 * @caution 플로이드 워샬 알고리즘 
 */
public class Problem1263 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int T = Integer.parseInt(input.readLine());
		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			tokenizer = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokenizer.nextToken());

			int[][] adj = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(tokenizer.nextToken());

					if (i == j)
						continue;

					if (temp == 0) {
						adj[i][j] = (int) Math.pow(10, 9);
					} else {
						adj[i][j] = temp;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if (j == k || j == i)
							continue;
						adj[i][j] = Math.min(adj[i][k] + adj[k][j], adj[i][j]);
					}
				}
			}

			int[] cc = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cc[i] += adj[i][j];
				}
			}

			Arrays.sort(cc);
			ans.append("#").append(t).append(" ").append(cc[0]).append("\n");
		}

		System.out.println(ans);
	}

}
