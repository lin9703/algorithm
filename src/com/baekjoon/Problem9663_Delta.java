package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 9663번 N-Queen
https://www.acmicpc.net/problem/9663

- 풀이법: Delta 사용 (for문)
  ㄴ time: 11860
*/
public class Problem9663_Delta {
    static int N;
    static int[] dx = {-1, 1, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        getQueenCases(0, new boolean[N][N]);

        System.out.println(cnt);

    }

    private static void getQueenCases(int idx, boolean[][] chess) {
        if (idx == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (available(chess, idx, i)) {
                chess[idx][i] = true;
                getQueenCases(idx + 1, chess);
                chess[idx][i] = false;
            }
        }

    }

    private static boolean available(boolean[][] chess, int idx, int i) {
        for (int j = 0; j < 6; j++) {
            int x = idx + dx[j];
            int y = i + dy[j];

            while (x >= 0 && y >= 0 && x < N && y < N) {
                if (chess[x][y])
                    return false;

                x += dx[j];
                y += dy[j];
            }
        }

        return true;
    }

}
