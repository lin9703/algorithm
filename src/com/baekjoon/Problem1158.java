package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 1158번 요세푸스 문제
https://www.acmicpc.net/problem/1158

풀이법: Queue 사용
- 시간복잡도 : 최대 O(N*K)
  ㄴ 명령어의 개수 N, 제거되는 주기 K
  ㄴ 통과 (Queue push: O(1), pop: O(1))
 */
public class Problem1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // number of people
        int K = Integer.parseInt(st.nextToken()); // order to remove

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int opti;
        while (!queue.isEmpty()) {
            /*
             Optimization
             But if K % queue.size() = 0, reset K to original.
             example: K=4, queue.size()=2
             */
            if (queue.size() < K) {
                opti = K % queue.size();
            } else {
                opti = K;
            }
            if (opti == 0) opti = K;

            for (int i = 0; i < opti - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb.toString());
    }
}
