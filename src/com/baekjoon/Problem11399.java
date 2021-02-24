package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 11399번 ATM
https://www.acmicpc.net/problem/11399

- 풀이법: 정렬
  ㄴ time: 136
*/
public class Problem11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        int sum = p[0];
        for (int i = 1; i < N; i++) {
            p[i] = p[i - 1] + p[i];
            sum += p[i];
        }

        System.out.println(sum);
    }

}
