package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
백준 2143번 분해합
https://www.acmicpc.net/problem/2143

- 풀이법: HashMap 사용
  ㄴ 음의 정수 고려
  ㄴ sum의 곱을 더하는 count의 경우 int 범위 초과 가능
  ㄴ time: 588
*/
public class Problem2143 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        T = Integer.parseInt(input.readLine());
        int N = Integer.parseInt(input.readLine());
        int[] A = new int[N];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int M = Integer.parseInt(input.readLine());
        int[] B = new int[M];
        tokenizer = new StringTokenizer(input.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Map<Integer, Integer> sumA = getSum(N, A);
        Map<Integer, Integer> sumB = getSum(M, B);

        long count = 0;
        for (int num : sumA.keySet()) {
            int temp = T - num;
            if (sumB.containsKey(temp)) {
                count += (long) sumA.get(num) * (long) sumB.get(temp);
            }
        }

        System.out.println(count);

    }

    private static Map<Integer, Integer> getSum(int n, int[] arr) {
        Map<Integer, Integer> result = new HashMap<>();
        int sum;
        int start = 0;
        while (start < n) {
            sum = 0;
            int index = start;

            while (index < n) {
                sum += arr[index++];

                if (result.containsKey(sum)) {
                    result.put(sum, result.get(sum) + 1);
                } else {
                    result.put(sum, 1);
                }
            }

            start++;
        }

        return result;
    }
}
