package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 7795번 먹을 것인가 먹힐 것인가
https://www.acmicpc.net/problem/7795

- 풀이법: 구현 (정렬 사용)
  ㄴ time: 356
*/
public class Problem7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int T = Integer.parseInt(input.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            tokenizer = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            tokenizer = new StringTokenizer(input.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(tokenizer.nextToken());
            }

            tokenizer = new StringTokenizer(input.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(tokenizer.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int bIdx = 0;
            int count = 0;
            for (int aIdx = 0; aIdx < N; aIdx++) {
                while (bIdx < M && A[aIdx] > B[bIdx]) {
                    bIdx++;
                }

                count += bIdx;
            }

            answer.append(count).append("\n");
        }

        System.out.println(answer);
    }
}
