package com.swea;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 18, 2021
 * @author lin9703
 * @problem SWEA 1247번 최적 경로
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD&categoryId=AV15OZ4qAPICFAYD&categoryType=CODE&problemTitle=1247&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 19,988
 * @time 252
 * @caution Backtracking 사용 (재귀 + Pruning)
 */
public class Problem1247 {
	static int N;
	static Point[] places;
	static int minDist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			places = new Point[N + 2];
			for (int i = 0; i < N + 2; i++) {
				places[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			minDist = Integer.MAX_VALUE;
			permutation(0, 0, 0, 0);

			sb.append("#").append(t).append(" ").append(minDist).append("\n");

		}

		System.out.println(sb);

	}

	private static void permutation(int toChoose, int flag, int idx, int dist) {
		if (minDist < dist)
			return;
		if (toChoose == N) {
			minDist = Math.min(minDist, dist + getDist(idx, 1));
			return;
		}

		for (int i = 2; i < N + 2; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			permutation(toChoose + 1, flag | 1 << i, i, dist + getDist(idx, i));
		}
	}

	private static int getDist(int startIdx, int arrivalIdx) {
		Point start = places[startIdx];
		Point arrival = places[arrivalIdx];

		return Math.abs(start.x - arrival.x) + Math.abs(start.y - arrival.y);
	}

}
