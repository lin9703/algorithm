package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2133번 타일 채우기
https://www.acmicpc.net/problem/2133

- 풀이법: DP
  ㄴ time: 76
*/
public class Problem2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int idx = Math.max(N + 1, 4);
        int[] tile = new int[idx];
        tile[0] = 1;
        tile[1] = 0;
        tile[2] = 3;
        tile[3] = 0;

        for (int i = 4; i <= N; i++) {
            tile[i] = tile[i - 2] * 3;
            for (int j = 4; i - j >= 0; j += 2)
                tile[i] += tile[i - j] * 2;
        }

        System.out.println(tile[N]);
    }

}
