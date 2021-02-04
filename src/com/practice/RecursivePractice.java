package com.practice;

import java.util.Arrays;

public class RecursivePractice {
    static char[] src = {'a', 'b', 'c', 'd'};
    static int cnt;

    public static void main(String[] args) {
        // 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("부분집합");
        //powerset();

        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("조합");
        cnt = 0;
        makeCombination(3, new char[3], 0);
        System.out.println(cnt + "번");

        // 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
        cnt = 0;
        makePermutation(3, new char[3], new boolean[src.length]);
        System.out.println(cnt + "번");
    }

    static void powerset() {

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
