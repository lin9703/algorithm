package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
백준 1662번 압축
https://www.acmicpc.net/problem/1662

- 첫 번째 풀이법: Stack으로 구현
  ㄴ time: 시간 초과
*/
public class Problem1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);

            if (temp == ')') {
                sb.setLength(0);
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                    sb.reverse();
                }

                stack.pop();
                int n = Integer.parseInt(String.valueOf(stack.pop()));
                for (; n > 0; n--) {
                    for (int j = 0; j < sb.length(); j++) {
                        stack.add(sb.charAt(j));
                    }
                }
            } else {
                stack.add(temp);
            }
        }

        System.out.println(stack.size());
    }
}
