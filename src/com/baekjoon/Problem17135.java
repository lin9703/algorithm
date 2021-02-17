package com.baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 17135번 캐슬 디펜스
https://www.acmicpc.net/problem/17135

- 풀이법: 조합 + 구현 (fail)
  ㄴ 한 번에 동시에 공격하는 경우 고려 -> targetEnemy 배열 생성 
  ㄴ time: 292	
*/
public class Problem17135 {
	static int N, M, D;
	static List<Point> enemies;
	static int maxKill = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		enemies = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				String temp = st.nextToken();

				if (temp.equals("1"))
					enemies.add(new Point(i, j));
			}
		}
		Collections.sort(enemies, (o1, o2) -> -Integer.compare(o1.x, o2.x));

		combination(0, new int[3], 0);

		System.out.println(maxKill);
	}

	private static void combination(int toChoose, int[] chosenIdx, int startIdx) {
		if (toChoose == 3) {
			maxKill = Math.max(maxKill, getKillCount(chosenIdx));
			return;
		}

		for (int i = startIdx; i < M; i++) {
			chosenIdx[toChoose] = i;
			combination(toChoose + 1, chosenIdx, i + 1);
		}
	}

	private static int getKillCount(int[] chosenIdx) {
		boolean[] isKilled = new boolean[enemies.size()];

		int kill = 0;
		int startIdx = 0; // 이동한 적 제외
		int[] targetEnemy = new int[3]; // 공격한 적의 인덱스 저장

		for (int i = N; i > 0; i--) { // N 길이만큼 공격 가능
			Arrays.fill(targetEnemy, -1);
			for (int j = 0; j < 3; j++) { // 궁수 수만큼 공격
				int dist = Integer.MAX_VALUE;

				for (int k = startIdx; k < enemies.size(); k++) {
					if (isKilled[k])
						continue;

					Point enemy = enemies.get(k);
					int temp = (i - enemy.x) + Math.abs(chosenIdx[j] - enemy.y);

					if (temp <= D) {
						if (temp < dist || (temp == dist && enemy.y < enemies.get(targetEnemy[j]).y)) {
							dist = temp;
							targetEnemy[j] = k;
						}
					}
				}
			}

			for (int idx : targetEnemy) {
				if (idx != -1 && !isKilled[idx]) {
					isKilled[idx] = true;
					kill++;
				}
			}

			while (startIdx < enemies.size() && enemies.get(startIdx).x >= i - 1) {
				startIdx++;
			}

		}

		return kill;
	}

}
