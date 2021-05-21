package com.programmers;

/*
프로그래머스 비밀지도
https://programmers.co.kr/learn/courses/30/lessons/17681

- 풀이법: 구현
  ㄴ 100 / 100
*/
public class Problem_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int binary = 0;
            int num = arr1[i];
            int index = 0;
            while (num > 0) {
                binary = binary | (num % 2) << index++;
                num /= 2;
            }

            num = arr2[i];
            index = 0;
            while (num > 0) {
                binary = binary | (num % 2) << index++;
                num /= 2;
            }

            sb.setLength(0);
            for (int j = n - 1; j >= 0; j--) {
                if ((binary & 1 << j) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
