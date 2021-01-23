package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2697번 다음수 구하기
https://www.acmicpc.net/problem/2697

- 유의점: char -> int 알파벳 자동 변환 (index 값 에러 주의)
 */
public class Problem2697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] num = new int[10];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();

            int pivot = 0;
            Arrays.fill(num, 0);

            for (int j = A.length() - 1; j > 0; j--) {
                num[Integer.parseInt(String.valueOf(A.charAt(j)))]++;

                if (A.charAt(j) > A.charAt(j - 1)) {
                    num[Integer.parseInt(String.valueOf(A.charAt(--j)))]++;
                    pivot = j;
                    break;
                }

                if (j == 0) {
                    pivot = 0;
                }
            }

            if (pivot != 0) {
                sb.append(A, 0, pivot);

                for (int j = Integer.parseInt(String.valueOf(A.charAt(pivot))) + 1; j < 10; j++) {
                    if (num[j] != 0) {
                        num[j]--;
                        sb.append(j);
                        break;
                    }
                }

                for (int j = 0; j < 10; j++) {
                    while (num[j] != 0) {
                        num[j]--;
                        sb.append(j);
                    }
                }
            } else {
                sb.append("BIGGEST");
            }

            sb.append("\n");

        }

        System.out.println(sb);


    }
}
