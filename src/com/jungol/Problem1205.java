package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since Feb 25, 2021
 * @author lin9703
 * @problem 정올 1205번 조커
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
 * @mem 13MB
 * @time 228ms
 * @caution 구현 + 투포인터
 */
public class Problem1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int joker = 0;
		List<Integer> nums = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == 0)
				joker++;
			else if (!nums.contains(num))
				nums.add(num);
		}

		Collections.sort(nums);
		nums.add(-1);

		List<Sequence> seq = new ArrayList<>();

		boolean isStart = true;
		int start = 0, len = 0;
		for (int i = 0; i < nums.size(); i++) {
			int num = nums.get(i);

			if (!isStart) {
				if (num - nums.get(i - 1) == 1) {
					len++;
				} else {
					seq.add(new Sequence(start, nums.get(i - 1), len));
					isStart = true;
				}
			}

			if (isStart) {
				start = num;
				len = 1;
				isStart = false;
			}

		}

		int maxLen = 0;
		int tempLen = 0;
		int useJoke = 0;
		int startIdx = 0;
		int endIdx = 0;
		while (endIdx < seq.size()) {
			if (startIdx == endIdx) {
				Sequence s = seq.get(startIdx);
				tempLen = s.len;
			} else if (startIdx < endIdx) {
				int diff = seq.get(endIdx).start - seq.get(endIdx - 1).end - 1;
				if (diff > joker) {
					startIdx = endIdx;
					useJoke = 0;
					continue;
				} else {
					while (useJoke + diff > joker) {
						tempLen -= (seq.get(startIdx + 1).start - seq.get(startIdx).start);
						useJoke -= (seq.get(startIdx + 1).start - seq.get(startIdx).end) - 1;
						startIdx++;
					}

					tempLen += (seq.get(endIdx).end - seq.get(endIdx - 1).end);
					useJoke += diff;
				}
			}

			maxLen = Math.max(maxLen, tempLen + (joker - useJoke));
			endIdx++;
		}

		if (seq.size() == 0)
			maxLen = joker;

		System.out.println(maxLen);

	}

	static class Sequence {
		int start;
		int end;
		int len;

		public Sequence(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}

	}
}
