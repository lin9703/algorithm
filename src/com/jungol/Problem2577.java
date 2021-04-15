package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
정올 2577번 회전 초밥(고)
http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1838&sca=99&sfl=wr_hit&stx=2577

- 풀이법: deque와 set 사용 (시간초과)
  ㄴ set 사용 -> 배열로 count 관리 (Fail)
  ㄴ 원형 큐 같은 느낌이라 N+K 까지 for문 돌려야 한다. (시간초과)
  ㄴ i % N 사용 (시간초과)
  ㄴ while문 if문으로 변경 (성공)
  ㄴ time: 868
*/
public class Problem2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int maxKinds = 0;
		int tempKinds = 1;
		int[] kinds = new int[d + 1];
		kinds[c]++;
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < N + k; i++) {
			int temp = sushi[i % N];

			deque.add(temp);
			if (kinds[temp] == 0) {
				tempKinds++;
			}
			kinds[temp]++;

			if (deque.size() > k) {
				int p = deque.poll();
				kinds[p]--;
				if (kinds[p] == 0) {
					tempKinds--;
				}
			}

			maxKinds = Math.max(maxKinds, tempKinds);
		}

		System.out.println(maxKinds);
	}
}
