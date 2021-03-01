package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
백준 15565번 귀여운 라이언
https://www.acmicpc.net/problem/15565

- 풀이법: 실패 2번 - 집합이 없다면 -1 출력 고려
  ㄴ time: 544
*/
public class Problem15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int num = nums[i];

            if (deque.isEmpty() && num == 1) {
                deque.add(num);
                cnt++;
            } else if (cnt > 0) {
                deque.add(num);
                if (num == 1) cnt++;
            }

            if (cnt == K) {
                ans = Math.min(ans, deque.size());

                deque.pollFirst();
                cnt--;
                while (deque.pollFirst().intValue() == 2) {
                }
                deque.addFirst(1);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }
}
