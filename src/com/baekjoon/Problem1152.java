package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1152번 단어의 개수
https://www.acmicpc.net/problem/1152

- 풀이법: StringTokenizer countTokens() 사용
*/
public class Problem1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int result = st.countTokens();

        System.out.println(result);
    }
}
