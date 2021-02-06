package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 15650번 N과 M (2)
https://www.acmicpc.net/problem/15650

- 풀이법: 재귀로 조합 구현
  ㄴ time: 128
*/
public class Problem15650 {
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

        combination(src, M, new int[M], 0);

        System.out.println(sb);

    }


    private static void printResult(int[] chosen) {
        for (int i : chosen) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }

    private static void combination(int[] src, int toChoose, int[] chosen, int startIdx) {
        if (toChoose == 0) {
            printResult(chosen);
            return;
        }

        for (int i = startIdx; i < src.length; i++) {
            chosen[chosen.length - toChoose] = src[i];
            combination(src, toChoose - 1, chosen, i + 1);
        }
    }

}
