package com.programmers;

import java.util.PriorityQueue;

/*
프로그래머스 더 맵게
https://programmers.co.kr/learn/courses/30/lessons/42626

- 풀이법: Priority Queue 이용
  ㄴ 50 / 50
*/
class Problem_더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int cnt = 0;
        while (pq.size() > 1) {
            int first = pq.poll().intValue();

            if (first >= K) {
                return cnt;
            } else {
                int second = pq.poll().intValue();
                pq.add(first + second * 2);
                cnt++;
            }

        }

        if (pq.size() == 1 && pq.peek() < K) {
            return -1;
        }

        return cnt;
    }
}