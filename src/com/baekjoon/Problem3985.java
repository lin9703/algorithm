package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 3985번 롤 케이크
https://www.acmicpc.net/problem/3985

- 풀이법: k부터 p까지의 범위 고려 안함 (실패) -> (성공)
  ㄴ time: 172
*/
public class Problem3985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] cakes = new boolean[L + 1];
        int expectIdx = 0;
        int expectNum = -1;
        int realIdx = 0;
        int realNum = -1;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (expectNum < k - p + 1) {
                expectNum = k - p + 1;
                expectIdx = i;
            }

            int temp = 0;
            for (int j = p; j <= k; j++) {
                if (!cakes[j]) {
                    cakes[j] = true;
                    temp++;
                }
            }

            if (realNum < temp) {
                realNum = temp;
                realIdx = i;
            }
        }

        System.out.println(expectIdx + "\n" + realIdx);
    }
}
