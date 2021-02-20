package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2999번 비밀 이메일
https://www.acmicpc.net/problem/2999

- 풀이법: 구현
  ㄴ time: 128
*/
public class Problem2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        int len = message.length();

        if (len == 0) {
            System.out.println("");
            return;
        }

        int r = 0, c = 0;
        for (int i = (int) Math.sqrt(len); i >= 0; i--) {
            if (len % i == 0) {
                c = Math.max(i, len / i);
                r = Math.min(i, len / i);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(message.charAt(i + r * j));
            }
        }

        System.out.println(sb);
    }
}
