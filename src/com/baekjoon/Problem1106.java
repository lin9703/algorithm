package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1106번 호텔
https://www.acmicpc.net/problem/1106

- 풀이법: 수많은 오답 (배열 사이즈 초기화)
  ㄴ 한 줄에 최대 비용 100 * 모집하는 최대 인원 1000 = 100000
  ㄴ time: 84
*/
public class Problem1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        int C = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());

        int[][] cities = new int[N][2];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            cities[i][0] = Integer.parseInt(tokenizer.nextToken()); // 드는 비용
            cities[i][1] = Integer.parseInt(tokenizer.nextToken()); // 얻을 수 있는 고객 수
        }

        int[] maxPeople = new int[100001]; // 모집하는 최대의 사람 수 (인덱스: 비용)

        maxPeople[0] = 0;
        int minCost = 0;

        if (C == 0) {
            System.out.println(minCost);
            return;
        }

        for (int i = 1; i <= 100000; i++) {
            int temp = 0;

            for (int j = 0; j < N; j++) {
                if (i >= cities[j][0])
                    temp = Math.max(temp, maxPeople[i - cities[j][0]] + cities[j][1]);
            }
            maxPeople[i] = temp;

            if (maxPeople[i] >= C) {
                minCost = i;
                break;
            }

        }

        System.out.println(minCost);
    }
}
