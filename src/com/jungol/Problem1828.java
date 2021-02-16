package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since Feb 16, 2021
 * @author lin9703
 * @problem 정올 1828번 냉장고
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
 * @mem 12MB
 * @time 160ms
 * @caution Priority Queue 사용 (그리디 문제)
 */
public class Problem1828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Chemistry> pq = new PriorityQueue<Chemistry>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Chemistry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int ans = 0;
		int min = -500;
		while (!pq.isEmpty()) {
			if (min < -270) {
				min = pq.poll().highest;
				ans++;
			}

			Chemistry temp = pq.poll();
			if (min < temp.lowest || min > temp.highest) {
				min = temp.highest;
				ans++;
			}
		}

		System.out.println(ans);

	}

	static class Chemistry implements Comparable<Chemistry> {
		int lowest, highest;

		public Chemistry(int lowest, int highest) {
			this.lowest = lowest;
			this.highest = highest;
		}

		@Override
		public int compareTo(Chemistry o) {
			return Integer.compare(this.highest, o.highest);
		}

	}
}
