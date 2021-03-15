package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Mar 18, 2021
 * @author lin9703
 * @problem SWEA 3289번 서로소 집합
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJKA6qr2oDFAWr&categoryId=AWBJKA6qr2oDFAWr&categoryType=CODE&problemTitle=3289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 102,420
 * @time 408
 * @caution Union-find 
 */
public class Problem3289 {
	static int n;
	static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			root = new int[n + 1];
			makeSet();

			ans.append("#").append(t).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) {
					union(a, b);
				} else if (op == 1) {
					if (find(a) == find(b)) {
						ans.append(1);
					} else {
						ans.append(0);
					}
				}
			}

			ans.append("\n");
		}

		System.out.println(ans);
	}

	private static int find(int n) {
		if (root[n] == n)
			return n;

		return root[n] = find(root[n]);
	}

	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if (aroot == broot)
			return;

		root[broot] = root[aroot];
	}

	private static void makeSet() {
		for (int i = 1; i <= n; i++) {
			root[i] = i;
		}
	}
}
