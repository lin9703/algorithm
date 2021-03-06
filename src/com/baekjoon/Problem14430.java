package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 14430번 자원 캐기
https://www.acmicpc.net/problem/14430

- 풀이법: DP
  ㄴ time: 192
*/
public class Problem14430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] resource = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                resource[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int temp = Math.max(resource[i - 1][j], resource[i][j - 1]);
                if (resource[i][j] == 1)
                    temp++;
                resource[i][j] = temp;
            }
        }

        System.out.println(resource[N][M]);
    }

}
