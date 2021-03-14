package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since Mar 16, 2021
 * @author lin9703
 * @problem 백준 1759번 암호 만들기
 * @see https://www.acmicpc.net/problem/1759
 * @mem 12720
 * @time 92
 * @caution 조합 사용 (실패 1번 -> 기존에 쓰던 chosen을 정렬하면 그렇게 유지된다.)
 */
public class Problem1759 {
	static int L;
	static List<Character> vowel;
	static List<Character> consonant;
	static StringBuilder sb = new StringBuilder();
	static List<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		vowel = new ArrayList<>(); // 모음
		consonant = new ArrayList<>(); // 자음
		ans = new ArrayList<>();
		for (int i = 0; i < C; i++) {
			char temp = st.nextToken().charAt(0);
			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
				vowel.add(temp);
			} else {
				consonant.add(temp);
			}
		}

		for (int i = 1; i <= L - 2; i++) {
			getVowelCode(0, i, new char[L], 0);
		}

		Collections.sort(ans);
		sb.setLength(0);
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append("\n");
		}
		System.out.println(sb);

	}

	private static void getVowelCode(int choose, int n, char[] chosen, int startIdx) {
		if (choose == n) {
			getConsCode(n, L, chosen, 0);
			return;
		}

		for (int i = startIdx; i < vowel.size(); i++) {
			chosen[choose] = vowel.get(i);
			getVowelCode(choose + 1, n, chosen, i + 1);
		}
	}

	private static void getConsCode(int choose, int n, char[] chosen, int startIdx) {
		if (choose == n) {
			char[] sort = Arrays.copyOf(chosen, chosen.length);
			Arrays.sort(sort);
			sb.setLength(0);
			for (int i = 0; i < L; i++) {
				sb.append(sort[i]);
			}
			ans.add(sb.toString());
			return;
		}

		for (int i = startIdx; i < consonant.size(); i++) {
			chosen[choose] = consonant.get(i);
			getConsCode(choose + 1, n, chosen, i + 1);
		}
	}
}
