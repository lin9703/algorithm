package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2609번 최대공약수와 최소공배수
https://www.acmicpc.net/problem/2609

- 풀이법: 유클리드 호제법 알고리즘 - GCD 구하기
  ㄴ time: 84
*/
public class Problem2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = getGCD(a, b);
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int getGCD(int a, int b) {
        int r;
        while (true) {
            r = a % b;
            if (r == 0) return b;
            a = b;
            b = r;
        }

    }
}
