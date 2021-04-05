package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
백준 8976번 LAGNO
https://www.acmicpc.net/problem/8976

- 풀이법: 오델로 구현
  ㄴ time: 80
*/
class Problem8976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().split("");
        }

        Queue<Point> q = new ArrayDeque();
        int r = 8;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                if (board[i][j].equals("W")) {
                    q.add(new Point(i, j));
                }
            }
        }

        int ans = 0;
        int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = p.x + deltas[i][0];
                int ny = p.y + deltas[i][1];

                if (nx >= r || nx < 0 || ny >= r || ny < 0) continue;
                if (board[nx][ny].equals(".")) {
                    int sum = 0;
                    for (int j = 0; j < 8; j++) {
                        int dx = nx;
                        int dy = ny;
                        int cnt = 0;
                        while (true) {
                            dx -= deltas[j][0];
                            dy -= deltas[j][1];

                            if (dx >= r || dx < 0 || dy >= r || dy < 0 || board[dx][dy].equals(".")) {
                                cnt = 0;
                                break;
                            } else if (board[dx][dy].equals("W")) {
                                cnt++;
                            } else if (board[dx][dy].equals("B")) {
                                break;
                            }

                        }
                        sum += cnt;

                    }

                    ans = Math.max(ans, sum);
                }
            }

        }

        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}