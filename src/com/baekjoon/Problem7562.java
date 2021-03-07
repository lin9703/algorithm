package com.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 7562번 나이트의 이동
https://www.acmicpc.net/problem/7562

- 풀이법: BFS - 최소값 구하기
  ㄴ time: 252
*/
public class Problem7562 {
    static int I;
    static int[][] chess;
    static int[][] knight;
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());

            knight = new int[2][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                knight[i][0] = Integer.parseInt(st.nextToken());
                knight[i][1] = Integer.parseInt(st.nextToken());
            }

            chess = new int[I][I];

            sb.append(BFS() - 1).append("\n");
        }

        System.out.println(sb);
    }

    private static int BFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(knight[0][0], knight[0][1]));
        chess[knight[0][0]][knight[0][1]] = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                if (chess[nx][ny] == 0) {
                    chess[nx][ny] = chess[x][y] + 1;
                    q.add(new Point(nx, ny));
                }

                if (nx == knight[1][0] && ny == knight[1][1]) {
                    return chess[nx][ny];
                }
            }
        }

        return -1;
    }

}
