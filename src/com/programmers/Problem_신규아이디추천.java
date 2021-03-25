package com.programmers;

/*
프로그래머스 신규 아이디 추천
https://programmers.co.kr/learn/courses/30/lessons/72410

- 풀이법: 구현
  ㄴ 100 / 100
*/
public class Problem_신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";

        // Rule 1
        new_id = rule1(new_id);

        // Rule 2
        new_id = rule2(new_id);

        // Rule 3
        new_id = rule3(new_id);

        // Rule 4
        new_id = rule41(new_id);
        new_id = rule42(new_id);

        // Rule 5
        if (new_id.isEmpty()) new_id = "a";

        // Rlue 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = rule42(new_id);
        }

        // Rule7
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id = new_id.concat(String.valueOf(new_id.charAt(new_id.length() - 1)));
            }
        }

        System.out.println(new_id);
    }

    private static String rule42(String new_id) {
        if (new_id.endsWith(".")) return new_id.substring(0, new_id.length() - 1);

        return new_id;
    }

    private static String rule41(String new_id) {
        if (new_id.startsWith(".")) return new_id.substring(1);

        return new_id;
    }

    private static String rule3(String new_id) {
        StringBuilder temp = new StringBuilder();
        boolean isDot = false;
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);

            if (c == '.') {
                if (!isDot) {
                    isDot = true;
                    temp.append(c);
                }
            } else {
                isDot = false;
                temp.append(c);
            }
        }
        new_id = temp.toString();
        return new_id;
    }

    private static String rule2(String new_id) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);

            if (Character.isLowerCase(c) || Character.isDigit(c)
                    || c == '-' || c == '_' || c == '.') {
                temp.append(c);
            }
        }
        return temp.toString();

    }

    private static String rule1(String new_id) {
        return new_id.toLowerCase();
    }
}
