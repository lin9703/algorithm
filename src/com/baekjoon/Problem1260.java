package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 1260번 DFS와 BFS
https://www.acmicpc.net/problem/1260

- 풀이법: DFS와 BFS
  ㄴ time: 224
*/
public class Problem1260 {
    static ArrayList<Integer>[] adj;
    static boolean[] isVisited;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adj[i]);
        }

        isVisited = new boolean[N + 1];
        Arrays.fill(isVisited, false);
        DFS(V);

        ans.append("\n");
        Arrays.fill(isVisited, false);
        BFS(V);


        System.out.println(ans);
    }

    private static void DFS(int v) {
        isVisited[v] = true;
        ans.append(v).append(" ");

        for (int temp : adj[v]) {
            if (!isVisited[temp])
                DFS(temp);
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            ans.append(temp).append(" ");

            for (int i = 0; i < adj[temp].size(); i++) {
                int n = adj[temp].get(i);
                if (!isVisited[n]) {
                    isVisited[n] = true;
                    queue.add(n);
                }
            }
        }

    }
}
