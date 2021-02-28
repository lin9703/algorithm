package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1205번 등수 구하기
https://www.acmicpc.net/problem/1205

- 풀이법: 구현 (실패 3번 - 예외 조건 처리)
  ㄴ time: 140
*/
public class Problem1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int scoreS = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int ans = -1;

        st = new StringTokenizer(br.readLine());
        int[] rank = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && rank[N] >= scoreS) {
            System.out.println(ans);
            return;
        }

        for (int i = 1; i <= P; i++) {
            if (i > N) {
                ans = i;
                break;
            }

            if (rank[i] <= scoreS) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
