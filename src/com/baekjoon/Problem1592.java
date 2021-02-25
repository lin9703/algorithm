package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1592번 영식이와 친구들
https://www.acmicpc.net/problem/1592

- 풀이법: 구현 (맨 처음 받는 건 count 하지 않는다.)
  ㄴ time: 128
*/
public class Problem1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int cnt = -1;
		int[] seat = new int[N + 1];
		int idx = 1;
		while (true) {
			seat[idx]++;
			cnt++;

			if (seat[idx] == M)
				break;
			if (seat[idx] % 2 != 0) {
				idx += L;
			} else {
				idx -= L;
			}

			if (idx > N)
				idx -= N;
			if (idx < 1)
				idx += N;
		}

		System.out.println(cnt);
	}

}
