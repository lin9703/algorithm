package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
백준 14425번 문자열 집합
https://www.acmicpc.net/problem/14425

- 처음 풀이: String의 contains() 사용
  ㄴ 시간복잡도
    ㄴ 1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000, 문자열 길이 최대 500 --> 최악일 경우 약 500억 -> 500초
    ㄴ 시간 초과
- 풀이법: HashSet 사용 -> 통과
  ㄴ 시간복잡도: O(N+M) (HashSet add: O(1), contains(1))
*/
public class Problem14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S.add(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String m = st.nextToken();

            if (S.contains(m)) {
                result++;
            }

        }

        System.out.println(result);
    }
}
