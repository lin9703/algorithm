package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
백준 17298번 오큰수
https://www.acmicpc.net/problem/17298

- 풀이법: Stack 이용 (시간초과)
  ㄴ StringBuilder 안에 +로 String 연결하는 코드 제거 (성공)
  ㄴ time: 1036
*/
public class Problem17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			int num = nums[i];

			int ans = -1;
			while (!stack.isEmpty()) {
				int temp = stack.pop();

				if (temp > num) {
					ans = temp;
					stack.push(temp);
					break;
				}
			}
			stack.push(num);

			nums[i] = ans;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}

}
