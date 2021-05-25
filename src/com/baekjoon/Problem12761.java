package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 12761번 돌다리
https://www.acmicpc.net/problem/12761

- 풀이법: 최단 거리 구하기 -> BFS
  ㄴ time: 116
*/
public class Problem12761 {
    static int A, B, N, M;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        A = Integer.parseInt(tokenizer.nextToken());
        B = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N] = true;
        int[] deltas = {+1, -1, +A, -A, +B, -B, A, B};

        int size;
        int minStep = 0;

        while (true) {
            minStep++;
            size = queue.size();
            while (size-- > 0) {
                int x = queue.poll();

                for (int i = 0; i < 8; i++) {
                    int nx;
                    if (i <= 5)
                        nx = x + deltas[i];
                    else
                        nx = x * deltas[i];

                    if (nx < 0 || nx > 100000) continue;
                    if (nx == M) return minStep;

                    if (!visited[nx]) {
                        visited[nx] = true;
                        queue.add(nx);
                    }
                }

            }
        }

    }

}
