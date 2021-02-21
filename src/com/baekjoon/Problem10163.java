package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 10163번 색종이
https://www.acmicpc.net/problem/10163

- 풀이법: 구현
  ㄴ time: 144
*/
public class Problem10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[101][101];
        for (int i = 0; i < 101; i++) {
            Arrays.fill(board[i], 0);
        }
        int[][] papers = new int[N + 1][4];
        int[] ans = new int[N + 1];
        Arrays.fill(ans, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int p = papers[i][0]; p < papers[i][0] + papers[i][2]; p++) {
                for (int q = papers[i][1]; q < papers[i][1] + papers[i][3]; q++) {
                    if (board[p][q] != 0) {
                        ans[board[p][q]]--;
                    }

                    board[p][q] = i;
                    ans[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }

}
