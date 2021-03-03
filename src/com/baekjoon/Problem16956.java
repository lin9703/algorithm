package com.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 16956번 늑대와 양
https://www.acmicpc.net/problem/16956

- 풀이법: BFS 사용
  ㄴ time: 260
*/
public class Problem16956 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();
        char[][] farm = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                farm[i][j] = temp.charAt(j);
                if (farm[i][j] == 'W') {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (farm[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                } else if (farm[nx][ny] == 'S') {
                    if (farm[p.x][p.y] == 'W') {
                        System.out.println(0);
                        return;
                    }

                    farm[p.x][p.y] = 'D';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < R; i++) {
            sb.append("\n");
            for (int j = 0; j < C; j++) {
                sb.append(farm[i][j]);
            }
        }

        System.out.println(sb);

    }
}
