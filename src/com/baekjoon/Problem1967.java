package com.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 1967번 트리의 지름
https://www.acmicpc.net/problem/1967

- 풀이법: DFS 2번
  ㄴ time: 184
*/
public class Problem1967 {
    static ArrayList<Point>[] adj;
    static boolean[] visited;
    static int maxSum = 0;
    static int maxNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int nodeNum = Integer.parseInt(input.readLine());

        adj = new ArrayList[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= nodeNum - 1; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            int parent = Integer.parseInt(tokenizer.nextToken());
            int child = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            adj[parent].add(new Point(child, weight));
            adj[child].add(new Point(parent, weight));
        }

        visited = new boolean[nodeNum + 1];
        getMaxSum(1, 0);

        maxSum = 0;
        Arrays.fill(visited, false);
        getMaxSum(maxNum, 0);

        System.out.println(maxSum);
    }

    private static void getMaxSum(int n, int sum) {
        visited[n] = true;

        for (int i = 0; i < adj[n].size(); i++) {
            int child = adj[n].get(i).x;
            int weight = adj[n].get(i).y;

            if (!visited[child]) {
                getMaxSum(child, sum + weight);
            } else {
                judgeMaxNum(n, sum);
            }
        }
    }

    private static void judgeMaxNum(int n, int sum) {
        if (sum >= maxSum) {
            maxSum = sum;
            maxNum = n;
        }
    }
}
