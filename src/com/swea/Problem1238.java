package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since Mar 16, 2021
 * @author lin9703
 * @problem SWEA 1238번 Contact
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 20,084
 * @time 121
 * @caution BFS
 */
public class Problem1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			List<Integer>[] adj = new ArrayList[101];
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				if (adj[a] == null)
					adj[a] = new ArrayList<Integer>();

				int b = Integer.parseInt(st.nextToken());
				if (!adj[a].contains(b))
					adj[a].add(b);
			}

			boolean[] visited = new boolean[101];
			Queue<Integer> q = new ArrayDeque<Integer>();
			q.add(start);
			visited[start] = true;

			int max = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				max = 0;

				while (size-- > 0) {
					int temp = q.poll();
					max = Math.max(max, temp);

					if (adj[temp] == null)
						continue;
					for (int i = 0; i < adj[temp].size(); i++) {
						int x = adj[temp].get(i);
						if (!visited[x]) {
							visited[x] = true;
							q.add(x);
						}
					}
				}

			}

			sb.append("#").append(t).append(" ").append(max).append("\n");

		}

		System.out.println(sb);
	}
}
