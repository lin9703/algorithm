package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 1520번 내리막 길
https://www.acmicpc.net/problem/1520

- 풀이법: DFS + DP (visited -1 초기화,
  ㄴ time: 328
*/
public class Problem1520 {
    static int M, N;
    static int[][] map;
    static int[][] visited;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        // input 값 받기
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // tokenizer 값 받기
        StringTokenizer tokenizer;

        // 산의 세로, 가로 받기
        tokenizer = new StringTokenizer(input.readLine());
        // 세로
        M = Integer.parseInt(tokenizer.nextToken());
        // 가로
        N = Integer.parseInt(tokenizer.nextToken());

        // 산의 map 정보
        map = new int[M][N];
        // 산의 map 정보 받기
        for (int i = 0; i < M; i++) {
            // tokenizer 객체 생성
            tokenizer = new StringTokenizer(input.readLine());
            // 행 기준으로 값 받기
            for (int j = 0; j < N; j++) {
                // map 정보 int형으로 저장
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        visited = new int[M][N];
        for (int index = 0; index < M; index++) {
            Arrays.fill(visited[index], -1);
        }
        DFS(0, 0);

        // 결과값 출력
        System.out.println(visited[0][0]);
    }

    private static int DFS(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        } else if (visited[x][y] != -1) {
            return visited[x][y];
        }

        visited[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];

            // 경계값 체크
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

            // 내리막길인지 체크
            if (map[nx][ny] < map[x][y]) {
                visited[x][y] += DFS(nx, ny);
            }
        }

        return visited[x][y];
    }
}

