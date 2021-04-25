package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 16235번 나무 재테크
https://www.acmicpc.net/problem/16235

- 풀이법: 2차원 배열 리스트 사용 + 구현
  ㄴ time: 1204
*/
public class Problem16235 {
    static int N, M, K;
    static int[][] add;
    static int[][] map;
    static List<Integer>[][] trees;
    static int[][] deltas = {{-1, -1}, {-1, 0}, {-1, +1}, {0, -1}, {0, +1}, {+1, -1}, {+1, 0},
            {+1, +1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        add = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        trees = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 5);
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            trees[x][y].add(z);
        }

        for (int i = 0; i < K; i++) {
            spring();
            fall();
            winter();
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count += trees[i][j].size();
            }
        }
        System.out.println(count);
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += add[i][j];
            }
        }

    }

    private static void fall() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j].isEmpty())
                    continue;

                List<Integer> tree = trees[i][j];
                for (int k = 0; k < tree.size(); k++) {
                    if (tree.get(k) % 5 == 0) {
                        for (int k2 = 0; k2 < 8; k2++) {
                            int nx = i + deltas[k2][0];
                            int ny = j + deltas[k2][1];

                            if (nx < 1 || ny < 1 || nx > N || ny > N)
                                continue;
                            trees[nx][ny].add(1);
                        }
                    }
                }
            }
        }

    }

    private static void spring() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (trees[i][j].isEmpty())
                    continue;

                // 봄
                List<Integer> tree = trees[i][j];
                List<Integer> temp = new ArrayList<>();
                Collections.sort(tree);
                int amount = map[i][j];
                int last = 0;
                while (last < tree.size()) {
                    if (amount - tree.get(last) >= 0) {
                        amount -= tree.get(last);
                        temp.add(tree.get(last) + 1);
                        last++;
                    } else {
                        break;
                    }
                }
                map[i][j] = amount;

                // 여름
                int sum = 0;
                for (int k = last; k < tree.size(); k++) {
                    sum += (int) tree.get(k) / 2;
                }

                map[i][j] += sum;

                trees[i][j] = temp;
            }
        }

    }
}
