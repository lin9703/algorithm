package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 3613번 Java vs C++
https://www.acmicpc.net/problem/3613

- 풀이법: ASCII 코드를 이용한 구현 -> 실패
*/
public class Problem3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String variableName = st.nextToken();
        int variableLength = variableName.length();

        StringBuilder sb = new StringBuilder();
        boolean isError = false;
        boolean isCplus = false;
        boolean isJava = false;
        for (int i = 0; i < variableLength; i++) {
            char c = variableName.charAt(i);
            if (c == '_') {
                isCplus = true;
                if (i == 0 || (i + 1) > variableLength) {
                    isError = true;
                } else {
                    c = variableName.charAt(++i);
                    if ((c >= 'A' && c <= 'Z') || c == '_') {
                        isError = true;
                    } else {
                        sb.append((char) (c - 32));
                    }
                }
            } else if (c >= 'A' && c <= 'Z') {
                isJava = true;
                sb.append("_");
                sb.append((char) (c + 32));
            } else if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                isError = true;
            }

            // error check
            if ((isCplus && isJava) || isError) {
                sb.setLength(0);
                sb.append("Error!");
                break;
            }
        }

        System.out.println(sb);
    }
}
