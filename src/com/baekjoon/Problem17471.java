package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 17471번 게리맨더링
https://www.acmicpc.net/problem/17471

- 풀이법: 구현 
  ㄴ time: 100
*/
public class Problem17471 {
	static int N;
	static int[] people;
	static int peopleSum = 0;
	static List<Integer>[] adj;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		people = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			peopleSum += people[i];
		}

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		subset(1, new boolean[N + 1]);

		if (minDiff == Integer.MAX_VALUE)
			minDiff = -1;

		System.out.println(minDiff);

	}

	private static void subset(int n, boolean[] visited) {
		if (n > N) {
			checkTwoParts(visited);
			return;
		}

		visited[n] = false;
		subset(n + 1, visited);
		visited[n] = true;
		subset(n + 1, visited);
	}

	private static void checkTwoParts(boolean[] visited) {
		List<Integer> find = new ArrayList<>();

		Queue<Integer> q = new ArrayDeque<>();
		boolean[] qvisited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!qvisited[i]) {
				int sum = people[i];
				q.add(i);
				qvisited[i] = true;

				while (!q.isEmpty()) {
					int t = q.poll();
					for (int j = 0; j < adj[t].size(); j++) {
						int v = adj[t].get(j);
						if (!qvisited[v] && (visited[v] == visited[t])) {
							qvisited[v] = true;
							sum += people[v];
							q.add(v);
						}
					}
				}

				find.add(sum);
			}
		}

		if (find.size() == 2) {
			minDiff = Math.min(minDiff, Math.abs(find.get(0) - find.get(1)));
		}

	}

}
