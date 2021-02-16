package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1074번 Z
https://www.acmicpc.net/problem/1074

- 첫 번째 풀이법: 2차원 배열에 count 값 저장 (메모리 초과)
- 두 번째 풀이법: 배열 삭제하고 count 값 출력 (시간 초과)
- 세 번째 풀이법: boolean 값으로 정답을 구하면 return 조건문 추가 (시간 초과) 
- 네 번째 풀이법: r, c 값의 범위가 아니면 바로 count 개수 추가 (fail)
  ㄴ count 개수 구할 때, len * len을 해줘야 한다. (solved)
  ㄴ time: 132
*/
public class Problem1074 {
	static int r, c;
	static int count = 0;
	static boolean isResult = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		divide(0, 0, 1 << N);

	}

	private static void divide(int startX, int startY, int len) {
		if (isResult)
			return;
		if (r < startX || r > startX + len || c < startY || c > startY + len) {
			count += Math.pow(len, 2);
			return;
		}
		if (len == 1) {
			if (startX == r && startY == c) {
				System.out.println(count);
				isResult = true;
			}
			count++;
			return;
		}

		divide(startX, startY, len / 2);
		divide(startX, startY + len / 2, len / 2);
		divide(startX + len / 2, startY, len / 2);
		divide(startX + len / 2, startY + len / 2, len / 2);
	}
}
