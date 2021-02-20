package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 3052번 나머지
https://www.acmicpc.net/problem/3052

- 풀이법: boolean 배열 이용
  ㄴ time: 128
*/
public class Problem3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        boolean[] used = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine()) % 42;

            if (!used[n]) {
                used[n] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
