package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 9663번 N-Queen
https://www.acmicpc.net/problem/9663

- 풀이법: 대각선 판단 공식 사용 (x 값의 차이만큼 y 값이 차이 나면 대각선이라고 판단 가능)
  ㄴ time: 4460
*/
public class Problem9663 {
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        getQueenCases(0, new int[N]);

        System.out.println(cnt);

    }

    private static void getQueenCases(int idx, int[] chess) {
        if (idx == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (available(chess, idx, i)) {
                chess[idx] = i;
                getQueenCases(idx + 1, chess);
            }
        }

    }

    private static boolean available(int[] chess, int idx, int i) {
        for (int j = 0; j < idx; j++) {
            if (chess[j] == i || Math.abs(chess[j] - i) == idx - j)
                return false;
        }

        return true;
    }

}
