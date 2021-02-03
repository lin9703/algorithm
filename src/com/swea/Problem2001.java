package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 3, 2021
 * @author lin9703
 * @problem SWEA 2001번 파리 퇴치
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=2001&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 20,016
 * @time 109
 * @caution 4중 for문으로 구현 (누적합도 사용 가능)
 */
public class Problem2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] flies = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					flies[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int sum = 0;
			int result = 0;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					sum = 0;
					for (int m = 0; m < M; m++) {
						for (int n = 0; n < M; n++) {
							sum += flies[i + m][j + n];
						}
					}

					result = Math.max(result, sum);
				}
			}

			// print
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

}
