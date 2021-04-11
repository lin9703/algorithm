package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 13458번 시험 감독
https://www.acmicpc.net/problem/13458

- 풀이법: 수학
  ㄴ 총감독의 수만큼 빼줄 때 감시해야 할 인원수가 음수가 나오는 경우 고려 (실패) -> break;가 아닌 continue; 사용 
  ㄴ 시험장의 개수와 응시자의 수가 1,000,000이고 감독들이 한 명씩 관리할 수 있으면 결과값이 int일 때 overflow 발생 -> long으로 변경 (실패) 
  ㄴ time: 428	
*/
public class Problem13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine());

		StringTokenizer tokenizer = new StringTokenizer(input.readLine());
		int[] testPeople = new int[N];
		for (int i = 0; i < N; i++) {
			testPeople[i] = Integer.parseInt(tokenizer.nextToken());
		}

		tokenizer = new StringTokenizer(input.readLine());
		int B = Integer.parseInt(tokenizer.nextToken());
		int C = Integer.parseInt(tokenizer.nextToken());

		long directorCount = N;
		for (int i = 0; i < N; i++) {
			int temp = testPeople[i];
			temp -= B;

			if (temp < 0) {
				continue;
			}

			directorCount += temp / C;
			if (temp % C > 0) {
				directorCount++;
			}

		}

		System.out.println(directorCount);
	}

}
