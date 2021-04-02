package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
백준 16637번 괄호 추가하기
https://www.acmicpc.net/problem/16637

- 풀이법: 브루트포스 (풀이법 참고)
  ㄴ 자바는 call by value라 배열의 reference 값이 복사가 되어서 사용된다.
  ㄴ time: 80
*/
public class Problem16637 {
    static int N;
    //static int[] equation;
    static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] equation = new int[N];
        for (int sIdx = 0; sIdx < N; sIdx++) {
            char temp = s.charAt(sIdx);

            if (temp == '+') equation[sIdx] = -1;
            else if (temp == '-') equation[sIdx] = -2;
            else if (temp == '*') equation[sIdx] = -3;
            else {
                equation[sIdx] = Character.getNumericValue(temp);
            }
        }

        getMaxResult(1, equation, 0);

        System.out.println(maxNum);
    }

    private static void getMaxResult(int choose, int[] chosen, int use) {
        if (choose >= N) {
            maxNum = Math.max(maxNum, calculate(chosen));
            return;
        }

        int[] chosen1 = Arrays.copyOf(chosen, N);
        int[] chosen2 = Arrays.copyOf(chosen, N);
        if (choose == 1 || (choose > 0 && (use & 1 << (choose - 2)) == 0))
            getMaxResult(choose + 2, calculate(chosen1, choose), use | 1 << choose);
        getMaxResult(choose + 2, chosen2, use);
    }

    private static int calculate(int[] chosen) {
        int result = chosen[0];
        for (int numIdx = 1; numIdx < N; numIdx += 2) {
            int op = chosen[numIdx];

            if (op == -1) {
                result += chosen[numIdx + 1];
            } else if (op == -2) {
                result -= chosen[numIdx + 1];
            } else if (op == -3) {
                result *= chosen[numIdx + 1];
            }

        }

        return result;
    }

    private static int[] calculate(int[] chosen, int choose) {
        int op = chosen[choose];
        if (op == -1) {
            chosen[choose - 1] = chosen[choose - 1] + chosen[choose + 1];
        } else if (op == -2) {
            chosen[choose - 1] = chosen[choose - 1] - chosen[choose + 1];
        } else if (op == -3) {
            chosen[choose - 1] = chosen[choose - 1] * chosen[choose + 1];
        }

        chosen[choose] = -1;
        chosen[choose + 1] = 0;

        return chosen;
    }
}
