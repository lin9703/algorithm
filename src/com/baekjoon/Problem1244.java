package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 1, 2021
 * @author lin9703
 * @problem 백준 1244번 스위치 켜고 끄기
 * @see https://www.acmicpc.net/problem/1244
 * @mem 14460
 * @time 128
 * @caution 구현
 */
public class Problem1244 {
	static byte[] swi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int switchNum = Integer.parseInt(st.nextToken());

		swi = new byte[switchNum + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < switchNum + 1; i++) {
			swi[i] = (byte) Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int studentNum = Integer.parseInt(st.nextToken());

		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 1-male, 2-female
			int num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				int index = num;
				int j = 1;
				while (index <= switchNum) {
					changeValue(index);
					index = num * ++j;
				}
			} else if (gender == 2) {
				int front = num - 1;
				int rear = num + 1;
				changeValue(num);
				while (front > 0 && rear <= switchNum) {
					if (swi[front] == swi[rear]) {
						changeValue(front);
						changeValue(rear);
					} else {
						break;
					}

					front -= 1;
					rear += 1;
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < switchNum + 1; i++) {
			sb.append(swi[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	static void changeValue(int index) {
		if (swi[index] == 0) {
			swi[index] = 1;
		} else {
			swi[index] = 0;
		}
	}

}
