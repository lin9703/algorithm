package com.programmers;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;

/*
프로그래머스 카카오 프렌즈 컬러링북
https://programmers.co.kr/learn/courses/30/lessons/1829

- 풀이법: BFS
  ㄴ 100 / 100
*/
public class Problem_카카오프렌즈컬러링북 {
    int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, BFS(m, n, picture, i, j));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int BFS(int m, int n, int[][] picture, int x, int y) {
        int size = 1;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + deltas[i][0];
                int ny = p.y + deltas[i][1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (picture[nx][ny] == picture[x][y] && !visited[nx][ny]) {
                    size++;
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return size;
    }
}
