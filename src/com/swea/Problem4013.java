package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
SWEA 4013. [모의 SW 역량테스트] 특이한 자석
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH&categoryId=AWIeV9sKkcoDFAVH&categoryType=CODE&problemTitle=4013&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&

- 풀이법: 구현 
  ㄴ time: 106
*/
public class Problem4013 {
	static int[][] wheels;
	static int[] wheelStart;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());

			wheels = new int[5][8];
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheels[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			wheelStart = new int[5];
			Arrays.fill(wheelStart, 0);

			int[][] rotate = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					rotate[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) {
				int num = rotate[i][0];
				int dir = rotate[i][1];

				if (num - 1 > 0 && wheels[num][judgeIndex(wheelStart[num] - 2)] != wheels[num - 1][judgeIndex(
						wheelStart[num - 1] + 2)]) {
					checkLeft(num - 1, -dir);
				}

				if (num + 1 <= 4 && wheels[num][judgeIndex(wheelStart[num] + 2)] != wheels[num + 1][judgeIndex(
						wheelStart[num + 1] - 2)]) {
					checkRight(num + 1, -dir);
				}

				wheelStart[num] = judgeIndex(wheelStart[num] - dir);
			}

			int sum = 0;
			for (int i = 1; i <= 4; i++) {
				if (wheels[i][wheelStart[i]] == 1)
					sum += Math.pow(2, i - 1);
			}
			ans.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.println(ans);
	}

	private static void checkLeft(int i, int dir) {
		if (i - 1 > 0 && wheels[i][judgeIndex(wheelStart[i] - 2)] != wheels[i - 1][judgeIndex(wheelStart[i - 1] + 2)]) {
			checkLeft(i - 1, -dir);
		}

		// 회전
		wheelStart[i] = judgeIndex(wheelStart[i] - dir);
	}

	private static void checkRight(int i, int dir) {
		if (i + 1 <= 4
				&& wheels[i][judgeIndex(wheelStart[i] + 2)] != wheels[i + 1][judgeIndex(wheelStart[i + 1] - 2)]) {
			checkRight(i + 1, -dir);
		}

		// 회전
		wheelStart[i] = judgeIndex(wheelStart[i] - dir);
	}

	private static int judgeIndex(int i) {
		if (i < 0) {
			i += 8;
		} else if (i >= 8) {
			i -= 8;
		}

		return i;
	}
}
