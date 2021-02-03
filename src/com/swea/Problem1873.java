package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since Feb 3, 2021
 * @author lin9703
 * @problem SWEA 1873번 상호의 배틀필드
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc&categoryId=AV5LyE7KD2ADFAXc&categoryType=CODE&problemTitle=1873&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 27,092
 * @time 143
 * @caution 구현 
 */
public class Problem1873 {
	static int H, W;
	static String[][] map;
	static String[] states = { "^", "v", "<", ">" };
	static int x = -1, y = -1, state = -1;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // height
			W = Integer.parseInt(st.nextToken()); // width

			map = new String[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				map[i] = st.nextToken().split("");

				List<String> temp = Arrays.asList(map[i]);

				// Up - 0, Down - 1, Left - 2, Right - 3
				for (int j = 0; j < 4; j++) {
					if (temp.contains(states[j])) {
						x = i;
						y = temp.indexOf(states[j]);
						state = j;
					}
				}
			}

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();

			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				switch (c) {
				case 'U':
					setInput(0);
					break;
				case 'D':
					setInput(1);
					break;
				case 'L':
					setInput(2);
					break;
				case 'R':
					setInput(3);
					break;
				case 'S':
					shoot();
				}

			}

			// print
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);

	}

	private static void setInput(int i) {
		state = i;
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < H && nx >= 0 && ny < W && ny >= 0 && map[nx][ny].equals(".")) {
			map[x][y] = ".";
			x = nx;
			y = ny;
		}

		map[x][y] = states[i];
	}

	private static void shoot() {
		int nx = x + dx[state];
		int ny = y + dy[state];

		while (nx < H && nx >= 0 && ny < W && ny >= 0) {
			if (map[nx][ny].equals("*")) {
				map[nx][ny] = ".";
				break;
			} else if (map[nx][ny].equals("#")) {
				break;
			}

			nx += dx[state];
			ny += dy[state];
		}
	}
}
