package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 4097번 수익
https://www.acmicpc.net/problem/4097

- 풀이법: 투 포인터
  ㄴ time: 572
*/
public class Problem4097 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(input.readLine());
            if (N == 0) {
                break;
            }

            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(input.readLine());
            }

            int start = 0, end = 0;
            int sum = prices[start];
            int maxSum = sum;
            while (true) {
                if (start == end) {
                    if (++end >= N) {
                        break;
                    }
                    sum += prices[end];
                } else if (prices[start] < 0 || sum < 0) {
                    sum -= prices[start++];
                } else {
                    if (++end >= N) {
                        break;
                    }
                    sum += prices[end];
                }

                maxSum = Math.max(maxSum, sum);
            }

            answer.append(maxSum).append("\n");
        }

        System.out.println(answer);
    }
}
