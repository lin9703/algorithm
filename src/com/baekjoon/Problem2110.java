package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2110번 공유기 설치
https://www.acmicpc.net/problem/2110

- 풀이법: 이분 탐색 (start, end 값 설정 주의 - 최대 거리이기 때문에 두 거리의 차를 기준으로 값을 설정해야 한다.)
  ㄴ time: 272
*/
public class Problem2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        int[] loc = new int[N];
        for (int i = 0; i < N; i++) {
            loc[i] = Integer.parseInt(input.readLine());
        }

        Arrays.sort(loc);

        int maxDistance = 1;
        int start = 1;
        int end = loc[loc.length - 1] - loc[1];
        while (start <= end) {
            int mid = (end + start) / 2;

            int value = loc[0] + mid;
            int count = 0;
            for (int i = 1; i < loc.length; i++) {
                if (loc[i] >= value) {
                    value = loc[i] + mid;
                    count++;
                }

                if (count == C - 1) {
                    break;
                }
            }

            if (count >= C - 1) {
                maxDistance = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(maxDistance);
    }
}
