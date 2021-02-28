package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 11660번 구간 합 구하기 5
https://www.acmicpc.net/problem/11660

- 풀이법: x축 누적합 이용 (성공)
  ㄴ time: 1852
*/
public class Problem11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cumulative = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 1; j < N + 1; j++) {
                sum += Integer.parseInt(st.nextToken());
                cumulative[i][j] = cumulative[i-1][j] + sum;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = cumulative[x2][y2] - cumulative[x1][y1];

            ans.append(sum).append("\n");
        }

        System.out.println(ans);
    }
}
