package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 14696번 딱지놀이
https://www.acmicpc.net/problem/14696

- 풀이법: 구현
  ㄴ time: 316
*/
public class Problem14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] acards = new int[5];
        int[] bcards = new int[5];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Arrays.fill(acards, 0);
            Arrays.fill(bcards, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                acards[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                bcards[Integer.parseInt(st.nextToken())]++;
            }

            int ans = 0;
            for (int j = 4; j >= 1; j--) {
                int judge = compareCard(acards[j], bcards[j]);
                if (judge != 0) {
                    ans = judge;
                    break;
                }
            }

            if (ans == 0) {
                sb.append("D").append("\n");
            } else if (ans == 1) {
                sb.append("A").append("\n");
            } else {
                sb.append("B").append("\n");
            }

        }

        System.out.println(sb);
    }

    private static int compareCard(int acard, int bcard) {
        if (acard > bcard) return 1;
        else if (acard < bcard) return -1;
        else return 0;
    }
}
