package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1541번 잃어버린 괄호
https://www.acmicpc.net/problem/1541

- 풀이법: 그리디
  ㄴ time: 76
*/
public class Problem1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String expession = input.readLine();
        int expressionLen = expession.length();

        int answer = 0;
        int pivot = 1;
        StringBuilder temp = new StringBuilder();
        for (int index = 0; index < expressionLen; index++) {
            char ch = expession.charAt(index);

            if (Character.isDigit(ch)) {
                temp.setLength(0);
                while (index < expressionLen && Character.isDigit((ch = expession.charAt(index)))) {
                    temp.append(ch);
                    index++;
                }
                index--;

                answer += pivot * Integer.parseInt(temp.toString());
            } else if (ch == '-') {
                pivot = -1;
            }
        }

        System.out.println(answer);
    }
}
