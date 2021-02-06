package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 15649번 N과 M (1)
https://www.acmicpc.net/problem/15649

- 풀이법: 재귀로 순열 구현
  ㄴ time: 292
*/
public class Problem15649 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] src = new int[N];
        int t = 1;
        for (int i = 0; i < N; i++) {
            src[i] = t++;
        }

        permutation(src, M, new int[M], new boolean[N]);

        System.out.println(sb);

    }


    private static void printResult(int[] chosen) {
        for (int i : chosen) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }

    private static void permutation(int[] src, int toChoose, int[] chosen, boolean[] isUsed) {
        if (toChoose == 0) {
            printResult(chosen);
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (!isUsed[i]) {
                chosen[chosen.length - toChoose] = src[i];
                isUsed[i] = true;
                permutation(src, toChoose - 1, chosen, isUsed);
                isUsed[i] = false;
            }
        }
    }

}
