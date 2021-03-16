package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Mar 18, 2021
 * @author lin9703
 * @problem 정올 1863번 종교
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1136&sca=99&sfl=wr_hit&stx=1863
 * @mem 30,588
 * @time 535
 * @caution Union-find
 */
public class Problem1863 {
	static int n;
	static int[] root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		root = new int[n + 1];
		makeSet();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (root[i] == i)
				cnt++;
		}

		System.out.println(cnt);

	}

	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);

		if (aroot == broot)
			return;

		root[broot] = aroot;
	}

	private static int find(int a) {
		if (root[a] == a)
			return a;

		return root[a] = find(root[a]);
	}

	private static void makeSet() {
		for (int i = 1; i <= n; i++) {
			root[i] = i;
		}
	}
}
