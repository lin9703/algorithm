package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @since Feb 25, 2021
 * @author lin9703
 * @problem SWEA 6485번 삼성시의 버스 노선
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWczm7QaACgDFAWn&categoryId=AWczm7QaACgDFAWn&categoryType=CODE&problemTitle=6485&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 52,628
 * @time 302
 * @caution 구현 + HashMap 사용
 */
public class Problem6485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		StringBuilder ans = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[][] lines = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				lines[i][0] = Integer.parseInt(st.nextToken());
				lines[i][1] = Integer.parseInt(st.nextToken());
			}

			int P = Integer.parseInt(br.readLine());
			int[] stops = new int[P];
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < P; i++) {
				stops[i] = Integer.parseInt(br.readLine());
				map.put(stops[i], 0);
			}

			for (int i = 0; i < N; i++) {
				for (int j = lines[i][0]; j <= lines[i][1]; j++) {
					if (map.containsKey(j)) {
						map.replace(j, map.get(j).intValue() + 1);
					}
				}
			}

			ans.append("#").append(t).append(" ");
			for (int i = 0; i < P; i++) {
				ans.append(map.get(stops[i]).intValue()).append(" ");
			}
			ans.append("\n");
		}

		System.out.println(ans);
	}

}
