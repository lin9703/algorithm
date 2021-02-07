package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 11729번 하노이 탑 이동 순서
https://www.acmicpc.net/problem/11729

- 풀이법: 재귀
  ㄴ time: 416
*/
public class Problem11729 {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);

    }

    private static void hanoi(int n, int from, int temp, int to) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, to, temp);
        sb.append(from + " " + to + "\n");
        cnt++;
        hanoi(n - 1, temp, from, to);
    }

}
