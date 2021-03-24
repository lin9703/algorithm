package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since Mar 24, 2021
 * @author lin9703
 * @problem SWEA 1251번 하나로
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD&categoryId=AV15StKqAQkCFAYD&categoryType=CODE&problemTitle=1251&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 * @mem 70,216
 * @time 250
 * @caution MST - 크루스칼 알고리즘 
 */
public class Problem1251 {
	static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		int T = Integer.parseInt(input.readLine());
		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(input.readLine());

			int[][] island = new int[N][2];
			for (int i = 0; i < 2; i++) {
				tokenizer = new StringTokenizer(input.readLine());
				for (int j = 0; j < N; j++) {
					island[j][i] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			double E = Double.parseDouble(input.readLine());

			ans.append("#").append(t).append(" ").append(Math.round(kruskal(N, island, E))).append("\n");
		}

		System.out.println(ans);

	}

	static class Info implements Comparable<Info> {
		int a, b;
		double len2;

		public Info(int a, int b, double len2) {
			this.a = a;
			this.b = b;
			this.len2 = len2;
		}

		@Override
		public int compareTo(Info o) {
			return Double.compare(this.len2, o.len2);
		}

	}

	private static double kruskal(int n, int[][] island, double e) {
		PriorityQueue<Info> lines = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				lines.add(new Info(i, j,
						Math.pow(island[i][0] - island[j][0], 2) + Math.pow(island[i][1] - island[j][1], 2)));
			}
		}

		root = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}

		double price = 0.0;
		Info info = null;
		for (int i = 0; i < n - 1; i++) {
			do {
				info = lines.poll();
			} while (!union(info.a, info.b));

			price += info.len2 * e;
		}

		return price;

	}

	private static int find(int a) {
		if (root[a] == a)
			return a;

		return root[a] = find(root[a]);
	}

	private static boolean union(int a, int b) {
		if (find(a) == find(b))
			return false;

		root[find(b)] = find(a);
		return true;
	}
}
