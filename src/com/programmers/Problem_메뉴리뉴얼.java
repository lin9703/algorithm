package com.programmers;

import java.util.*;

/*
프로그래머스 메뉴 리뉴얼
https://programmers.co.kr/learn/courses/30/lessons/72411

- 풀이법: HashMap & 조합 사용
  ㄴ 100 / 100
*/
public class Problem_메뉴리뉴얼 {
    static Map<String, Integer> map;
    static int max = 0;

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        char[][] order = new char[orders.length][];
        for (int i = 0; i < orders.length; i++) {
            order[i] = orders[i].toCharArray();
            Arrays.sort(order[i]);
        }

        map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < course.length; j++) {
            int n = course[j];
            map.clear();
            max = 0;

            for (int i = 0; i < orders.length; i++) {
                if (n > order[i].length) continue;
                combination(n, 0, order[i], new char[n], 0);
            }

            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        ans.add(key);
                    }
                }
            }

        }

        Collections.sort(ans);
        String[] result = new String[ans.size()];
        result = ans.toArray(result);
        System.out.println(Arrays.toString(result));
    }

    private static void combination(int len, int choose, char[] order, char[] chosen, int startIdx) {
        if (choose == len) {
            String key = String.valueOf(chosen);
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
                max = Math.max(max, map.get(key));
            } else {
                map.put(key, 1);
            }

            return;
        }

        for (int i = startIdx; i < order.length; i++) {
            chosen[choose] = order[i];
            combination(len, choose + 1, order, chosen, i + 1);
        }
    }
}
