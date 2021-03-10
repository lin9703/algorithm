package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 3055번 탈출
https://www.acmicpc.net/problem/3055

- 풀이법: BFS
  ㄴ time: 84
*/
public class Problem3055 {
    static int R, C;
    static Character[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];
        visited = new boolean[R][C];
        Queue<int[]> flood = new ArrayDeque<>();
        Queue<int[]> dochi = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '*') {
                    flood.add(new int[]{i, j});
                } else if (map[i][j] == 'S') {
                    dochi.add(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[R][C];
        int fsize = flood.size();
        int dsize = dochi.size();
        int t = 0;
        boolean find = false;

        while (true) {
            while (fsize-- > 0) {
                int[] temp = flood.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + deltas[i][0];
                    int ny = temp[1] + deltas[i][1];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == '.') {
                        flood.add(new int[]{nx, ny});
                        map[nx][ny] = '*';
                    }
                }
            }

            while (dsize-- > 0) {
                int[] temp = dochi.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + deltas[i][0];
                    int ny = temp[1] + deltas[i][1];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        dochi.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                    if (map[nx][ny] == 'D') {
                        find = true;
                        break;
                    }
                }
            }
            t++;

            fsize = flood.size();
            dsize = dochi.size();
            if (find) {
                System.out.println(t);
                return;
            } else if (dsize == 0) {
                System.out.println("KAKTUS");
                return;
            }
        }


    }

}
