package com.leetcode;

/*
LeetCode 693. Binary Number with Alternating Bits
https://leetcode.com/problems/binary-number-with-alternating-bits/

- 풀이법: 구현
  ㄴ time: 1 ms (O(w))
*/
public class Problem693 {
    public static void main(String[] args) {
        int n = 11;

        System.out.println(hasAlternatingBits(n));
    }

    static public boolean hasAlternatingBits(int n) {
        String binaryNumber = makeBinaryNumber(n);

        char preC = binaryNumber.charAt(0);
        for (int idx = 1; idx < binaryNumber.length(); idx++) {
            char c = binaryNumber.charAt(idx);

            if (c == preC) {
                return false;
            }

            preC = c;
        }

        return true;
    }

    private static String makeBinaryNumber(int n) {
        StringBuilder tempStr = new StringBuilder();
        while (n != 0) {
            tempStr.append(n % 2);
            n /= 2;
        }
        return tempStr.reverse().toString();
    }
}
