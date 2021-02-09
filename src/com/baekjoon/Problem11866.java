package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 11866번 요세푸스 문제 0
https://www.acmicpc.net/problem/11866

- 풀이법: Queue 사용 
- 시간: 188 -> 최적화 후 172 
*/
public class Problem11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!queue.isEmpty()) {
			int opti = K % queue.size();
			if (opti == 0) {
				opti = K;
			}

			for (int i = 1; i < opti; i++) {
				queue.offer(queue.poll());
			}

			sb.append(queue.poll());
			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append(">");

		System.out.println(sb);
	}

}
