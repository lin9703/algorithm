package com.programmers;

import java.util.HashMap;
import java.util.Map;

/*
프로그래머스 [카카오 인턴] 키패드 누르기
https://programmers.co.kr/learn/courses/30/lessons/67256

- 풀이법: 구현
  ㄴ 100.0 / 100.0
*/
class Problem_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> keypad = new HashMap<>();
        keypad.put(0, new int[]{3, 1});
        keypad.put(1, new int[]{0, 0});
        keypad.put(2, new int[]{0, 1});
        keypad.put(3, new int[]{0, 2});
        keypad.put(4, new int[]{1, 0});
        keypad.put(5, new int[]{1, 1});
        keypad.put(6, new int[]{1, 2});
        keypad.put(7, new int[]{2, 0});
        keypad.put(8, new int[]{2, 1});
        keypad.put(9, new int[]{2, 2});

        int[] left = {3, 0};
        int[] right = {3, 2};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num % 3 == 1) {
                result.append("L");
                left = keypad.get(num);
            } else if (num % 3 == 0 && num != 0) {
                result.append("R");
                right = keypad.get(num);
            } else {
                int[] numLoc = keypad.get(num);
                int leftDis = Math.abs(numLoc[0] - left[0]) + Math.abs(numLoc[1] - left[1]);
                int rightDis = Math.abs(numLoc[0] - right[0]) + Math.abs(numLoc[1] - right[1]);
                if (leftDis == rightDis) {
                    if (hand.charAt(0) == 'r') {
                        result.append("R");
                        right = keypad.get(num);
                    } else {
                        result.append("L");
                        left = keypad.get(num);
                    }
                } else if (leftDis < rightDis) {
                    result.append("L");
                    left = keypad.get(num);
                } else {
                    result.append("R");
                    right = keypad.get(num);
                }
            }

        }
        return result.toString();
    }
}