package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 1406번 에디터
https://www.acmicpc.net/problem/1406

풀이법: Stack, switch문 사용
- 시간복잡도 : 최대 O(N+M)
  ㄴ 문자열의 길이 N, 명령어의 개수 M
  ㄴ 추가될 수 있으니 문자열의 최대 길이는 N+M -> 모든 문자열이 출력을 위해 push 되었다가 pop 되니 총 시간복잡도는 O(N+M)
  ㄴ 통과 (Stack push: O(1), pop: O(1), search: O(N))
 */
public class Problem1406UsingStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        Stack stackA = new Stack();
        Stack stackB = new Stack();

        for(int i=0; i<str.length(); i++) {
            stackA.push(str.charAt(i));
        }

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // total command number

        String command;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken(); // command

            switch (command) {
                case "L":
                    if (!stackA.isEmpty()) {
                        stackB.push(stackA.pop());
                    }
                    break;
                case "D":
                    if (!stackB.isEmpty()) {
                        stackA.push(stackB.pop());
                    }
                    break;
                case "B":
                    if (!stackA.isEmpty()) {
                        stackA.pop();
                    }
                    break;
                case "P":
                    stackA.push(st.nextToken());
                    break;
            }

        }

        while(!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stackB.isEmpty()) {
            sb.append(stackB.pop());
        }

        System.out.println(sb.toString());
    }
}
