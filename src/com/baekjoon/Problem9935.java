package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

/*
백준 9935번 문자열 폭발
https://www.acmicpc.net/problem/9935

- 풀이법: Stack 사용
  ㄴ time: 536
*/
public class Problem9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] bomb = br.readLine().toCharArray();
        int lastPoint = bomb.length - 1;

        Stack<Character> stack = new Stack<>();
        int point = lastPoint;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == bomb[point]) {
                while (--point >= 0 && !stack.isEmpty() && stack.peek() == bomb[point]) {
                    stack.pop();
                }

                if (point == -1) {
                    point = lastPoint;
                } else {
                    while (point < lastPoint)
                        stack.add(bomb[++point]);
                }
            } else {
                stack.add(c);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Iterator<Character> it = stack.iterator(); it.hasNext(); ) {
                sb.append(it.next());
            }
            System.out.println(sb);
        }
    }
}
