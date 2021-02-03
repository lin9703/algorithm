package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2231번 분해합
https://www.acmicpc.net/problem/2231

- 첫 풀이: 실패
*/
public class Problem2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int numN = Integer.parseInt(N);

        int temp = numN - (numN % (int) Math.pow(10, (int) (Math.log10(numN))));

        int result = Integer.MAX_VALUE;
        result = getConstructor(numN, temp, result);

        temp = numN;
        result = getConstructor(numN, temp, result);

        if (result == Integer.MAX_VALUE) {
            result = 0;
        }

        System.out.println(result);
    }

    private static int getConstructor(int numN, int temp, int result) {
        int sum = Integer.MAX_VALUE;
        while (sum >= numN) {
            sum = getSum(--temp);
            if (sum == numN) {
                if (temp < result) {
                    result = temp;
                }
            }
        }
        return result;
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
