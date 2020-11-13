package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
백준 1874번 스택 수열

풀이법: Stack 사용
- 오름차순(Ascending Order) : arrange them from smallest to largest
 */
public class Problem1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // total amount

        StringBuilder sb = new StringBuilder(); // result append
        int pushNum = 1; // from 1 to N
        int num; // output num
        Stack stack = new Stack();
        boolean isTrue = true; // whether a sequence can be made or not
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            while (num >= pushNum) {
                stack.push(pushNum++);
                sb.append("+\n");
            }

            if ((int) stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                isTrue = false;
                break;
            }
        }

        if (isTrue) {
            System.out.println(sb.toString().trim());
        } else {
            System.out.println("NO");
        }

    }
}
