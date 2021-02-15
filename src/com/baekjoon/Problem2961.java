package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 2961번 도영이가 만든 맛있는 음식
https://www.acmicpc.net/problem/2961

- 첫 번째 풀이법: 부분집합 인자로 신맛과 쓴맛 저장 (실패) 
- 두 번째 풀이법: 부분집합 인자로 flag 사용 (비트마스크 사용) 
			+ 재료 적어도 하나는 사용해야 한다는 조건 처리 (실패) 
			+ 신맛과 쓴맛 차이의 절대값 구하기 (성공)
  ㄴ time: 128
*/
public class Problem2961 {
	static int N;
	static List<Ingredient> ingredients;
	static long result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		ingredients = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients.add(new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		powerset(0, 0);

		System.out.println(result);
	}

	private static void powerset(int idx, int flag) {
		if (idx == N) {
			if (flag != 0) {
				int sour = 1;
				int bitter = 0;
				for (int i = 0; i < N; i++) {
					if ((flag & 1 << i) != 0) {
						sour *= ingredients.get(i).sour;
						bitter += ingredients.get(i).bitter;
					}
				}
				result = Math.min(result, Math.abs(sour - bitter));
			}
			return;
		}

		powerset(idx + 1, flag | 1 << idx);
		powerset(idx + 1, flag);
	}

	static class Ingredient {
		int sour;
		int bitter;

		public Ingredient(int sour, int bitter) {
			this.sour = sour;
			this.bitter = bitter;
		}

	}

}
