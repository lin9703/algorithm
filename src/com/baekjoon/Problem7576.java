package com.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 7576번 토마토
https://www.acmicpc.net/problem/7576

- 풀이법: BFS 사용
  ㄴ time: 608
*/
public class Problem7576 {
    static int N, M;
    static int[][] tomatoes;
    static Queue<Point> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];
        queue = new LinkedList<>();
        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 0) zeroCnt++;
                else if (tomatoes[i][j] == 1) queue.add(new Point(i, j));
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }

        BFS();

        int minDate = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                minDate = Math.max(minDate, tomatoes[i][j]);
            }
        }

        System.out.println(minDate - 1);

    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (tomatoes[nx][ny] == 0 ||
                        (tomatoes[nx][ny] > 0 && tomatoes[p.x][p.y] + 1 < tomatoes[nx][ny])) {
                    queue.add(new Point(nx, ny));
                    tomatoes[nx][ny] = tomatoes[p.x][p.y] + 1;
                }
            }
        }
    }
}
