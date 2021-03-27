package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
백준 1755번 숫자놀이
https://www.acmicpc.net/problem/1755

- 풀이법: HashMap, Comparable 사용
  ㄴ time: 80
*/
public class Problem1755 {
    public static void main(String[] args) throws IOException {
        // 0~9까지의 문자열 담는 map 생성 및 값 넣기
        Map<Integer, String> nums = new HashMap<>();
        nums.put(0, "zero");
        nums.put(1, "one");
        nums.put(2, "two");
        nums.put(3, "three");
        nums.put(4, "four");
        nums.put(5, "five");
        nums.put(6, "six");
        nums.put(7, "seven");
        nums.put(8, "eight");
        nums.put(9, "nine");

        // 입력 값 처리
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        // M이상 N 이하의 입력 값 변수 할당
        int startM = Integer.parseInt(tokenizer.nextToken());
        int endN = Integer.parseInt(tokenizer.nextToken());

        // 입력 값 범위의 숫자와 사전명을 넣을 배열 생성
        Num[] numToString = new Num[endN - startM + 1];

        // numToString index
        int idx = 0;
        // for문 안의 string 값 기록하기 위한 sb 생성
        StringBuilder sb = new StringBuilder();
        // numToString 배열에 값 넣기
        for (int i = startM; i <= endN; i++) {
            sb.setLength(0); // sb 초기화
            // num 값 string으로 변경
            int num = i;
            while (num > 0) {
                sb.insert(0, nums.get(num % 10));
                num /= 10;
            }

            // Num 형식으로 배열에 저장
            numToString[idx++] = new Num(i, sb.toString());
        }

        // numToString 배열 정렬 (string 기준)
        Arrays.sort(numToString);

        // string 기준으로 numToString 숫자값 뽑아내기
        sb.setLength(0);
        for (int i = 0; i < numToString.length; i++) {
            if (i != 0 && i % 10 == 0)
                sb.append("\n");
            sb.append(numToString[i].num).append(" ");
        }

        // 결과값 출력
        System.out.println(sb);
    }

    static class Num implements Comparable<Num> {
        int num;
        String string;

        public Num(int num, String string) {
            this.num = num;
            this.string = string;
        }

        // 정렬 시, string 기준으로 정렬
        @Override
        public int compareTo(Num o) {
            return this.string.compareTo(o.string);
        }
    }
}
