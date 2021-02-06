package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursivePractice {
    static char[] src = {'a', 'b', 'c', 'd'};
    static int cnt;

    public static void main(String[] args) {
        // 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("부분집합");
        cnt = 0;
        powerset(4, new boolean[4]);
        System.out.println(cnt + "번\n");

        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("조합");
        cnt = 0;
        makeCombination(3, new char[3], 0);
        System.out.println(cnt + "번\n");

        // 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
        cnt = 0;
        makePermutation(3, new char[3], new boolean[src.length]);
        System.out.println(cnt + "번\n");
    }

    static void print(boolean[] choosed) {
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < choosed.length; i++) {
            if (choosed[i]) {
                result.add(src[i]);
            }
        }
        System.out.println(cnt + ": " + result);
    }

    static void powerset(int toChoose, boolean[] choosed) {
        if (toChoose == 0) {
            cnt++;
            print(choosed);
            return;
        }

        choosed[choosed.length - toChoose] = true;
        powerset(toChoose - 1, choosed);
        choosed[choosed.length - toChoose] = false;
        powerset(toChoose - 1, choosed);

    }

    static void makeCombination(int toChoose, char[] choosed, int startIdx) {
        if (toChoose == 0) {
            System.out.println(Arrays.toString(choosed));
            cnt++;
            return;
        }

        for (int i = startIdx; i < src.length; i++) {
            choosed[choosed.length - toChoose] = src[i];
            makeCombination(toChoose - 1, choosed, i + 1);
        }
    }

    static void makePermutation(int toChoose, char[] choosed, boolean[] visited) {
        if (toChoose == 0) {
            System.out.println(Arrays.toString(choosed));
            cnt++;
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            choosed[choosed.length - toChoose] = src[i];
            visited[i] = true;
            makePermutation(toChoose - 1, choosed, visited);
            visited[i] = false;
        }
    }
}
