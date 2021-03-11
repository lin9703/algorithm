package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 14889번 스타트와 링크
https://www.acmicpc.net/problem/14889

- 풀이법: 조합 사용 - 전체 원소의 합은 의미가 없다.
  ㄴ time: 288
*/
public class Problem14889 {
    static int N;
    static int[][] abilities;
    static int sum = 0;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        abilities = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
                if (abilities[j][i] != 0) {
                    abilities[j][i] += abilities[i][j];
                }
                sum += abilities[i][j];
            }
        }

        combination(0, new boolean[N], 0);

        System.out.println(diff);
    }

    private static void combination(int toChoose, boolean[] chosen, int startIdx) {
        if (toChoose == N / 2) {
            int num = getDiff(chosen);
            diff = Math.min(diff, num);
            return;
        }
        for (int i = startIdx; i < N; i++) {
            chosen[i] = true;
            combination(toChoose + 1, chosen, i + 1);
            chosen[i] = false;

        }
    }

    private static int getDiff(boolean[] chosen) {
        int t = 0;
        int f = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (chosen[i] == chosen[j]) {
                    if (chosen[i]) t += abilities[i][j];
                    else f += abilities[i][j];
                }
            }
        }

        return Math.abs(t - f);
    }
}
