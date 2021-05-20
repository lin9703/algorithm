package com.programmers;

/*
프로그래머스 2개 이하로 다른 비트
https://programmers.co.kr/learn/courses/30/lessons/77885

- 풀이법: 구현
  ㄴ 100 / 100
*/
public class Problem_2개이하로다른비트 {
    public long[] solution(long[] numbers) {
        int numbersLen = numbers.length;
        long[] answer = new long[numbersLen];

        for (int i = 0; i < numbersLen; i++) {
            char[] num = Long.toBinaryString(numbers[i]).toCharArray();
            int n = num.length;
            char[] numCopy = new char[n + 1];
            numCopy[0] = '0';
            System.arraycopy(num, 0, numCopy, 1, n);

            for (int j = n; j >= 0; j--) {
                if (numCopy[j] == '0') {
                    numCopy[j] = '1';
                    if (j + 1 <= n) {
                        numCopy[j + 1] = '0';
                    }
                    break;
                }
            }

            answer[i] = Long.parseLong(String.valueOf(numCopy), 2);
        }
        return answer;
    }
}
