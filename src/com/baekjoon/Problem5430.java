package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
백준 5430번 AC
https://www.acmicpc.net/problem/5430

- 풀이법: Deque 사용
  ㄴ time: 1096
  ㄴ 실패 2번: String substring 범위 고려 / []일 때 D가 있어야만 error
*/
public class Problem5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            boolean isOrder = true;
            boolean isError = false;

            st = new StringTokenizer(x.substring(1, x.length() - 1), ",");

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);

                switch (c) {
                    case 'R':
                        isOrder = !isOrder;
                        break;
                    case 'D':
                        if (!deque.isEmpty()) {
                            if (isOrder) {
                                deque.pollFirst();
                            } else {
                                deque.pollLast();
                            }
                        } else isError = true;
                }

                if (isError) break;
            }

            // print
            if (!isError) {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (isOrder) {
                        while (!deque.isEmpty())
                            sb.append(deque.pollFirst()).append(",");
                    } else {
                        while (!deque.isEmpty())
                            sb.append(deque.pollLast()).append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]");
            } else {
                sb.append("error");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
