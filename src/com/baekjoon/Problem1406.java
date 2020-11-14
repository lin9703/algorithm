package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 1406번 에디터
https://www.acmicpc.net/problem/1406

풀이법: ArrayList, switch문 사용
- 시간복잡도 : 최대 O(n제곱)
  ㄴ 시간 초과 (ArrayList add: O(1), remove: O(n))
 */
public class Problem1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        List<String> input = new ArrayList<>(Arrays.asList(st.nextToken().split(""))); // input text array
        int inputSize = input.size();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // total command number

        int cursor = inputSize;
        String command;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken(); // command

            switch (command) {
                case "L":
                    cursor--;
                    if (cursor < 0) cursor = 0;
                    break;
                case "D":
                    cursor++;
                    if (cursor > inputSize) cursor = inputSize;
                    break;
                case "B":
                    if (cursor != 0) {
                        input.remove(--cursor);
                        inputSize--;
                    }
                    break;
                case "P":
                    String add = st.nextToken();
                    input.add(cursor++, add);
                    inputSize++;
                    break;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }

        System.out.println(sb.toString());

    }
}
