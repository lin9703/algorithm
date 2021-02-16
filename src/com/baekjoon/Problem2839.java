package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2839번 설탕 배달
https://www.acmicpc.net/problem/2839

- 풀이법
  ㄴ time: 132
*/
public class Problem2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		if ((N % 5) % 3 == 0) {
			count += N / 5;
			count += (N % 5) / 3;

			System.out.println(count);
			return;
		}

		for (int i = N / 5 - 1; i >= 0; i--) {
			if ((N - (i * 5)) % 3 == 0) {
				count += i;
				count += (N - (i * 5)) / 3;
				break;
			}
		}

		if (count == 0) {
			count = -1;
		}
		System.out.println(count);

	}
}
