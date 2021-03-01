package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
백준 2667번 단지번호붙이기
https://www.acmicpc.net/problem/2667

- 풀이법: DFS 사용
  ㄴ time: 132
*/
public class Problem2667 {
    static int N;
    static String[][] adj;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new String[N][];
        for (int i = 0; i < N; i++) {
            adj[i] = br.readLine().split("");
        }

        isVisited = new boolean[N][N];
        List<Integer> danji = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j].equals("1") && !isVisited[i][j]) {
                    cnt = 0;
                    DFS(i, j);
                    danji.add(cnt);
                }
            }
        }

        Collections.sort(danji);
        StringBuilder ans = new StringBuilder();
        ans.append(danji.size()).append("\n");
        for (Integer i : danji) {
            ans.append(i).append("\n");
        }

        System.out.println(ans);

    }

    private static void DFS(int x, int y) {
        isVisited[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (adj[nx][ny].equals("1") && !isVisited[nx][ny])
                DFS(nx, ny);
        }
    }
}
