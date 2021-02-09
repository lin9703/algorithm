package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1662번 압축
https://www.acmicpc.net/problem/1662

- 첫 번째 풀이법: Stack으로 구현
  ㄴ time: 시간 초과
- 두 번째 풀이법: 재귀로 구현
  ㄴ time: 128
*/
public class Problem1662 {
    static String S;
    static int point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        S = st.nextToken();

        System.out.println(getLen());
    }

    private static int getLen() {
        int result = 0;

        while (true) {
            if (point == S.length()) {
                break;
            }
            char temp = S.charAt(point++);

            if (temp == '(') {
                result--;
                result += Integer.parseInt(String.valueOf(S.charAt(point - 2))) * getLen();
            } else if (temp == ')') {
                break;
            } else {
                result++;
            }
        }

        return result;
    }

}
