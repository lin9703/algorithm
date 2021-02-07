package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 1436번 영화감독 숌
https://www.acmicpc.net/probem/1436

- 풀이법: 브루트포스 
  ㄴ time: 328
*/
public class Problem1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int count = 0;
		for (int i = 666;; i++) {
			if (Integer.toString(i).contains("666")) {
				count++;
			}

			if (count == N) {
				System.out.println(i);
				break;
			}
		}

	}
}
