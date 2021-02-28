package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 1449번 수리공 항승
https://www.acmicpc.net/problem/1449

- 풀이법: 그리디 (실패 2번 - index 처리)
  ㄴ time: 140
*/
public class Problem1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] leak = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak);

        int cnt = 0;
        int i = 0;
        while (i < N) {
            int start = leak[i];
            cnt++;

            while (++i < N && leak[i] - start < L) {
            }
        }

        System.out.println(cnt);
    }
}
