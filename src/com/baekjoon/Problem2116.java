package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2116번 주사위 쌓기
https://www.acmicpc.net/problem/2116

- 풀이법: 브루트포스 재귀
  ㄴ time: 240
*/
public class Problem2116 {
    static int N;
    static int[][] dices;
    static int[] meet = {5, 3, 4, 1, 2, 0};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        dices = new int[N][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            getMaxNum(0, i, 0);
        }

        System.out.println(result);
    }

    private static void getMaxNum(int toChoose, int idx, int sum) {
        int n = 6;
        for (int i = 0; i < 2; i++) {
            if (dices[toChoose][meet[idx]] == n) n--;
            else if (dices[toChoose][idx] == n) n--;
        }
        sum += n;

        if (toChoose == N - 1) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (dices[toChoose + 1][i] == dices[toChoose][idx]) {
                getMaxNum(toChoose + 1, meet[i], sum);
                break;
            }
        }

    }
}
