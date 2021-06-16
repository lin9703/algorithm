package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 18352번 특정 거리의 도시 찾기
https://www.acmicpc.net/problem/18352

- 풀이법: BFS (size 사용)
  ㄴ time: 1216
*/
public class Problem18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int X = Integer.parseInt(tokenizer.nextToken());

        List<Integer>[] cities = new ArrayList[N + 1];
        for (int cityIndex = 1; cityIndex <= N; cityIndex++) {
            cities[cityIndex] = new ArrayList<>();
        }

        for (int mIndex = 0; mIndex < M; mIndex++) {
            tokenizer = new StringTokenizer(input.readLine());
            int A = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());

            cities[A].add(B);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        List<Integer> result = new ArrayList<>();

        queue.add(X);
        visited[X] = true;

        int size;
        int distance = 0;
        while (!queue.isEmpty()) {
            size = queue.size();

            while (size-- > 0) {
                int poll = queue.poll();

                for (int pollIndex = 0; pollIndex < cities[poll].size(); pollIndex++) {
                    int temp = cities[poll].get(pollIndex);
                    if (!visited[temp]) {
                        queue.add(temp);
                        visited[temp] = true;
                    }
                }
            }

            distance++;

            if (distance == K) {
                size = queue.size();
                for (int resultIndex = 0; resultIndex < size; resultIndex++) {
                    result.add(queue.poll());
                }

                break;
            }
        }

        Collections.sort(result);

        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            StringBuilder answer = new StringBuilder();
            for (int resultIndex = 0; resultIndex < result.size(); resultIndex++) {
                answer.append(result.get(resultIndex)).append("\n");
            }

            System.out.println(answer);
        }
    }
}
