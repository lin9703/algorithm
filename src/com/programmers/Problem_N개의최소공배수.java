package com.programmers;

/*
프로그래머스 N개의 최소공배수
https://programmers.co.kr/learn/courses/30/lessons/12953

- 풀이법: 구현
  -> 다른 풀이법: 2개씩 최소공배수 계속 비교하는 방식도 사용 가능
  ㄴ 100 / 100
*/
public class Problem_N개의최소공배수 {
    public int solution(int[] arr) {
        int len = arr.length;
        boolean[] notPrimeNum = getPrimeNumber();

        int commonMultiple = 1;
        int index = 2;
        while (index < 100) {
            if (!notPrimeNum[index]) {
                int prime = index;
                int count = 0;
                for (int i = 0; i < len; i++) {
                    if (arr[i] % prime == 0) {
                        count++;
                    }
                }

                if (count >= 2) {
                    commonMultiple *= prime;
                    for (int i = 0; i < len; i++) {
                        if (arr[i] % prime == 0) {
                            arr[i] = arr[i] / index;
                        }
                    }
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }

        for (int i = 0; i < len; i++) {
            commonMultiple *= arr[i];
        }
        return commonMultiple;
    }

    private boolean[] getPrimeNumber() {
        boolean[] notPrimeNum = new boolean[101]; // false - prime number

        for (int i = 2; i < 100; i++) {
            int mul = 2;
            while (i * mul <= 100) {
                notPrimeNum[i * mul] = true;
                mul++;
            }
        }

        return notPrimeNum;
    }
}
