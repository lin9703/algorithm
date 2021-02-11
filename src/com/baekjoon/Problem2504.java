package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
백준 2504번 괄호의 값
https://www.acmicpc.net/problem/2504

- 첫 번째 풀이법: String Stack으로 구현 (실패)
- 두 번째 풀이법: Integer Stack으로 구현 (성공)
  ㄴ time: 132
*/
public class Problem2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        Stack<Integer> stack = new Stack<>();
        boolean isTrue = true;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // [: -3, (: -2
            if (c == '[') {
                stack.push(-3);
            } else if (c == '(') {
                stack.push(-2);
            } else if (c == ']') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek().intValue() > 0) {
                    sum += stack.pop();
                }

                if (!stack.isEmpty() && stack.pop() == -3) {
                    if (sum == 0) {
                        stack.add(3);
                    } else {
                        stack.add(sum * 3);
                    }
                } else {
                    isTrue = false;
                    break;
                }
            } else if (c == ')') {
                int sum = 0;
                while (!stack.isEmpty() && stack.peek().intValue() > 0) {
                    sum += stack.pop();
                }

                if (!stack.isEmpty() && stack.pop() == -2) {
                    if (sum == 0) {
                        stack.add(2);
                    } else {
                        stack.add(sum * 2);
                    }
                } else {
                    isTrue = false;
                    break;
                }
            } else {
                isTrue = false;
                break;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            int t = stack.pop();
            if (t < 0) {
                isTrue = false;
                break;
            } else {
                result += t;
            }
        }

        if (isTrue) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }

}
