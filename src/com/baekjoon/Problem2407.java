package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2407번 조합
https://www.acmicpc.net/problem/2407

- 풀이법: 곱하는 수의 소수의 제곱수로 count
  ㄴ long 범위 초과 -> BigInteger 사용 (성공)
  ㄴ time: 140
*/
public class Problem2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numCnt = new int[98];
        Arrays.fill(numCnt, 0);
        for (int i = n; i > n - m; i--) {
            int num = i;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                while (num % j == 0) {
                    numCnt[j]++;
                    num /= j;
                }

                if (num == 1) break;
            }

            numCnt[num]++;
        }

        for (int i = m; i > 1; i--) {
            int num = i;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                while (num % j == 0) {
                    numCnt[j]--;
                    num /= j;
                }

                if (num == 1) break;
            }

            numCnt[num]--;
        }

        BigInteger combi = BigInteger.ONE;
        for (int i = 1; i < 98; i++) {
            if (numCnt[i] > 0) {
                combi = combi.multiply(BigInteger.valueOf((long) Math.pow(i, numCnt[i])));
            }
        }

        for (int i = 1; i < 98; i++) {
            if (numCnt[i] < 0) {
                combi = combi.divide(BigInteger.valueOf((long) Math.pow(i, numCnt[i])));
            }
        }

        System.out.println(combi);
    }
}
