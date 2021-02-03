package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2231번 분해합
https://www.acmicpc.net/problem/2231

- 첫 풀이: 실패
- 풀이법: 브루트포스
*/
public class Problem2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numN = Integer.parseInt(st.nextToken());

        int result = getConstructor(numN);
        System.out.println(result);
    }

    private static int getConstructor(int numN) {
        for (int i = 0; i < numN; i++) {
            int sum = getSum(i);
            if (sum == numN) {
                return i;
            }
        }
        return 0;
    }

    private static int getSum(int n) {
        int sum = n;
        int len = (int) (Math.log10(n));
        for (int i = len; i >= 0; i--) {
            sum += (n / (int) Math.pow(10, i));
            n %= (int) Math.pow(10, i);
        }
        return sum;
    }
}
