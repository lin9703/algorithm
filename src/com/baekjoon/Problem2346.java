package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
백준 2346번 풍선 터뜨리기
https://www.acmicpc.net/problem/2346

- 풀이법: Deque 이용 
  ㄴ time: 196
*/
public class Problem2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Balloon> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
		}

		StringBuilder sb = new StringBuilder();

		int num = 1;
		Balloon balloon;
		while (!deque.isEmpty()) {
			if (num > 0) {
				while (--num > 0) {
					deque.addLast(deque.pollFirst());
				}
				balloon = deque.pollFirst();
			} else {
				while (++num < 0) {
					deque.addFirst(deque.pollLast());
				}
				balloon = deque.pollLast();
			}

			num = balloon.num;
			sb.append(balloon.idx).append(" ");
		}

		System.out.println(sb);
	}

	static class Balloon {
		int idx;
		int num;

		public Balloon(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

	}

}
