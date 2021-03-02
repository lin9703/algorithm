package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 2644번 촌수계산
https://www.acmicpc.net/problem/2644

- 풀이법: BFS 이용 (실패 2번 - 배열 얕은 복사 및 break문 처리)
  ㄴ time: 80
*/
public class Problem2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            adj[child].add(parent);
            adj[parent].add(child);
        }

        int[] visitedCnt = new int[N + 1];
        Arrays.fill(visitedCnt, 0);

        int ans = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < adj[x].size(); i++) {
                int temp = adj[x].get(i);

                if (temp == b) {
                    ans = visitedCnt[x] + 1;
                    break;
                }
                if (visitedCnt[temp] == 0 && temp != a) {
                    visitedCnt[temp] = visitedCnt[x] + 1;
                    queue.add(temp);
                }
            }
        }

        System.out.println(ans);
    }
}
