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
- 두 번째 풀이법:
  ㄴ time: 128
*/
public class Problem2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String[] s = S.split("");

        Stack<String> stack = new Stack<>();
        boolean isTrue = true;
        for (int i = 0; i < S.length(); i++) {
            String c = s[i];

            if (c.equals("[") || c.equals("(")) {
                stack.push(c);
            } else if (c.equals("]")) {
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                    stack.add("3");
                } else if (!stack.isEmpty() && isNumeric(stack.peek())) {
                    int n = Integer.parseInt(stack.pop());
                    if (!stack.isEmpty() && stack.pop().equals("[")) {
                        if (!stack.isEmpty() && isNumeric(stack.peek())) {
                            n = n * 3 + Integer.parseInt(stack.pop());
                            stack.push(String.valueOf(n));
                        } else {
                            stack.push(String.valueOf(n * 3));
                        }
                    } else {
                        isTrue = false;
                        break;
                    }
                }
            } else if (c.equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                    stack.add("2");
                } else if (!stack.isEmpty() && isNumeric(stack.peek())) {
                    int n = Integer.parseInt(stack.pop());
                    if (!stack.isEmpty() && stack.pop().equals("(")) {
                        if (!stack.isEmpty() && isNumeric(stack.peek())) {
                            n = n * 2 + Integer.parseInt(stack.pop());
                            stack.push(String.valueOf(n));
                        } else {
                            stack.push(String.valueOf(n * 2));
                        }
                    } else {
                        isTrue = false;
                        break;
                    }
                }
            } else {
                isTrue = false;
                break;
            }
        }

        if (isTrue && stack.size() == 1) {
            System.out.println(stack.pop());
        } else {
            System.out.println(0);
        }
    }

    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
