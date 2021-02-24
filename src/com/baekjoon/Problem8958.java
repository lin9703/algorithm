package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 8958번 OX퀴즈
https://www.acmicpc.net/problem/8958

- 풀이법: 구현
  ㄴ time: 136
*/
public class Problem8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int ans = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            String problem = st.nextToken();
            for (int j = 0; j < problem.length(); j++) {
                char c = problem.charAt(j);
                if (c == 'O') {
                    ans++;
                    sum += ans;
                } else if (ans != 0) {
                    ans = 0;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

}
