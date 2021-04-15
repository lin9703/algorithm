package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 14888번 연산자 끼워넣기
https://www.acmicpc.net/problem/14888

- 풀이법: NP (실패)
  ㄴ 2단계 pivot - 1과 교환할 때 초과가 아니라 이상일 때도 넘겨야 한다.
  ㄴ 음수 값을 받아올 수 있으니 max 값 초기화는 Integer.MIN_VALUE로 해야 한다.
  ㄴ time: 92 
*/
public class Problem14888 {
	static int[] nums;
	static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		nums = new int[N];
		StringTokenizer st = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] op = new int[4]; // + - * / 순서
		int opLen = 0;
		st = new StringTokenizer(input.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			opLen += op[i];
		}

		int[] opNum = new int[opLen];
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < op[i]; j++) {
				opNum[k++] = i;
			}
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		calculate(opNum);
		while (nextPermutation(opNum)) {
		}

		System.out.println(max);
		System.out.println(min);
	}

	private static boolean nextPermutation(int[] opNum) {
		int pivot = opNum.length - 1;
		while (pivot > 0 && opNum[pivot - 1] >= opNum[pivot]) {
			pivot--;
		}

		if (pivot == 0)
			return false;

		int j = opNum.length - 1;
		while (opNum[pivot - 1] >= opNum[j]) {
			j--;
		}
		swap(opNum, pivot - 1, j);

		int k = opNum.length - 1;
		while (pivot < k) {
			swap(opNum, pivot, k);
			pivot++;
			k--;
		}

		calculate(opNum);
		return true;
	}

	private static void calculate(int[] opNum) {
		int result = nums[0];
		for (int i = 0; i < opNum.length; i++) {
			if (opNum[i] == 0) {
				result += nums[i + 1];
			} else if (opNum[i] == 1) {
				result -= nums[i + 1];
			} else if (opNum[i] == 2) {
				result *= nums[i + 1];
			} else if (opNum[i] == 3) {
				result /= nums[i + 1];
			}
		}

		max = Math.max(max, result);
		min = Math.min(min, result);
	}

	private static void swap(int[] opNum, int pivot, int j) {
		int temp = opNum[pivot];
		opNum[pivot] = opNum[j];
		opNum[j] = temp;
	}
}
