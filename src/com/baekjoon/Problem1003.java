package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1003번 피보나치 함수
https://www.acmicpc.net/problem/1003

- 풀이법: DP
  ㄴ time: 76
*/
public class Problem1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] num = new int[T];
        int max = 0;
        for (int t = 0; t < T; t++) {
            num[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[t]);
        }

        int[][] call = new int[max + 1][2];
        call[0][0] = 1;
        call[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            call[i][0] = call[i - 1][0] + call[i - 2][0];
            call[i][1] = call[i - 1][1] + call[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(call[num[i]][0]).append(" ").append(call[num[i]][1]).append("\n");
        }

        System.out.println(sb);
    }

}
