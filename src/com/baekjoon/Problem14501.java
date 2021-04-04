package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 14501번 퇴사
https://www.acmicpc.net/problem/14501

- 풀이법: 조합 사용
  ㄴ time: 88
*/
public class Problem14501 {
    static int N;
    static int[][] consult;
    static int maxPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        consult = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            consult[i][0] = Integer.parseInt(st.nextToken());
            consult[i][1] = Integer.parseInt(st.nextToken());
        }

        maxPrice = 0;
        combination(0, 0);

        System.out.println(maxPrice);

    }

    private static void combination(int sum, int startIdx) {
        if (startIdx > N) {
            return;
        }

        for (int i = startIdx; i < N; i++) {
            combination(sum + consult[i][1], i + consult[i][0]);
        }

        maxPrice = Math.max(maxPrice, sum);
    }
}

