package com.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
프로그래머스 프린터
https://programmers.co.kr/learn/courses/30/lessons/42587

- 풀이법: 배열 정렬과 Queue 이용
  ㄴ 50 / 50
*/
class Problem_프린터 {
    public int solution(int[] priorities, int location) {
        int[] order = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(order);
        int idx = order.length - 1;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        int rank = 0;
        while (!q.isEmpty()) {
            if (q.peek()[1] == order[idx]) {
                rank++;
                idx--;
                if (q.poll()[0] == location) {
                    return rank;
                }
            } else {
                q.add(q.poll());
            }
        }

        return 0;
    }
}