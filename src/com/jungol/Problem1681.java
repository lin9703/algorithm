package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Mar 22, 2021
 * @author lin9703
 * @problem 정올 1681번 해밀턴 순환회로
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=99&sfl=wr_hit&stx=1681
 * @mem 12MB
 * @time 223
 * @caution 백트래킹 (실패 1번- 마지막에서 회사로 돌아갈 때도 길이 있는지 check)
 */
public class Problem1681 {
	static int N;
	static int[][] route;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());

		route = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				route[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		getMinCost(1, 1, 0 | 1 << 1, 0);

		System.out.println(min);

	}

	private static void getMinCost(int idx, int cnt, int visited, int sum) {
		if (sum > min)
			return;
		if (cnt == N) {
			if (route[idx][1] != 0) {
				sum += route[idx][1];
				min = Math.min(min, sum);
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if ((visited & 1 << i) != 0)
				continue;
			if (route[idx][i] == 0)
				continue;

			getMinCost(i, cnt + 1, visited | 1 << i, sum + route[idx][i]);
		}

	}
}
