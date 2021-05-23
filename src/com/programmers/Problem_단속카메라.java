package com.programmers;

import java.util.PriorityQueue;

/*
프로그래머스 단속카메라
https://programmers.co.kr/learn/courses/30/lessons/42884

- 풀이법: 그리디
  ㄴ 정확성: 50.0 + 효율성: 50.0 = 100.0 / 100.0
*/
public class Problem_단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        int minCount = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1[0], o2[0]));
        for (int i = 0; i < routes.length; i++) {
            pq.add(routes[i]);
        }

        minCount++;
        int start = pq.poll()[0];
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[1] >= start) {
            } else {
                minCount++;
                start = temp[0];
            }
        }

        return minCount;
    }
}
