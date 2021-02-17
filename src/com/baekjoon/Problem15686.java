package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 15686번 치킨 배달
https://www.acmicpc.net/problem/15686

- 풀이법: 조합 사용 (시간초과)
  ㄴ 조합 매개변수로 flag 비트마스킹을 사용하는 대신 chosen 배열 사용 (성공)
  ㄴ time: 200
*/
public class Problem15686 {
	static int N, M;
	static List<Location> chickens, houses;
	static int minCity = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chickens = new ArrayList<>();
		houses = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());

				if (n == 1)
					houses.add(new Location(i, j));
				else if (n == 2)
					chickens.add(new Location(i, j));
			}
		}

		combination(0, new Location[M], 0);

		System.out.println(minCity);
	}

	static class Location {
		int r;
		int c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void combination(int toChoose, Location[] chosen, int startIdx) {
		if (toChoose == M) {
			minCity = Math.min(minCity, getCityValue(chosen));
			return;
		}

		for (int i = startIdx; i < chickens.size(); i++) {
			chosen[toChoose] = chickens.get(i);
			combination(toChoose + 1, chosen, i + 1);
		}
	}

	private static int getCityValue(Location[] chosen) {
		int cityRoad = 0;
		for (int i = 0; i < houses.size(); i++) {
			int min = Integer.MAX_VALUE;
			Location house = houses.get(i);

			for (int j = 0; j < M; j++) {
				Location chicken = chosen[j];

				int temp = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
				min = Math.min(min, temp);
			}

			cityRoad += min;
		}

		return cityRoad;
	}

}
