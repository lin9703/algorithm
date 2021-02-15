package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 15, 2021
 * @author lin9703
 * @problem SWEA 6808번 규영이와 인영이의 카드게임
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE&problemTitle=6808&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 20,368
 * @time 1,834
 * @caution 순열 이용
 */
public class Problem6808 {
	static int[] gCards, iCards;
	static int win, lose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int cards = 0; // bit가 1이면 규영이 카드 (1부터 18까지 사용)
			gCards = new int[9];
			iCards = new int[9];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int temp = Integer.parseInt(st.nextToken());
				gCards[i] = temp;
				cards = cards | 1 << temp;
			}

			int j = 0;
			for (int i = 1; i <= 18; i++) {
				if ((cards & 1 << i) == 0) {
					iCards[j++] = i;
				}
			}

			win = 0;
			lose = 0;

			//permutation(0, 0, 0);
			do {
				int score = 0;
				for(int i=0; i<9; i++) {
					score += getScore(gCards[i], iCards[i]);
				}
				if (score > 0)
					win++;
				else if (score < 0)
					lose++;
			} while(nextpermutation());
			
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}

		System.out.println(sb);
	}

	/* permutation 이용 
	private static void permutation(int toChoose, int flag, int score) {
		if (toChoose == 9) {
			if (score > 0)
				win++;
			else if (score < 0)
				lose++;

			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			permutation(toChoose + 1, flag | 1 << i, score + getScore(gCards[toChoose], iCards[i]));
		}
	}
	*/

	private static int getScore(int i, int j) {
		if (i > j)
			return i + j;
		else if (i == j)
			return 0;
		else
			return -(i + j);
	}
	
	private static boolean nextpermutation() {
		int k = 9 - 1;
		while(k > 0 && iCards[k-1] > iCards[k]) {
			k--;
		}
		if(k == 0) {
			return false;
		}
		int i = k;
		
		int l = 9 - 1;
		while(l >= 0 && iCards[i-1] > iCards[l]) {
			l--;
		}
		swap(i-1, l);
		
		int m = 9 - 1;
		while(i < m) {
			swap(i, m);
			i++;
			m--;
		}
		
		return true;		
	}

	private static void swap(int i, int j) {
		int temp = iCards[i];
		iCards[i] = iCards[j];
		iCards[j] = temp;
	}
}
