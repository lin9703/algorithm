package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
백준 2559번 수열
https://www.acmicpc.net/problem/2559

- 풀이법: Deque 사용
  ㄴ time: 328
*/
public class Problem2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            deque.addLast(num);
            sum += num;

            if (deque.size() > K) {
                sum -= deque.pollFirst().intValue();
            }

            if (deque.size() == K && sum > ans) ans = sum;
        }

        System.out.println(ans);
    }

}
