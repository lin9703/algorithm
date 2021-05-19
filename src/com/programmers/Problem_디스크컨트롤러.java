package com.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
프로그래머스 디스크 컨트롤러
https://programmers.co.kr/learn/courses/30/lessons/42627

- 풀이법: 그리디
  ㄴ 100 / 100
*/
public class Problem_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int jobsLen = jobs.length;
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int delay = 0;
        int time = jobs[0][0];
        int index = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1[1], o2[1]));
        while (!(pq.isEmpty() && index == jobsLen)) {

            while (index < jobsLen && jobs[index][0] <= time) {
                pq.add(jobs[index]);
                index++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                System.out.println(job[0] + " " + job[1]);
                delay += job[1] + (time - job[0]);
                time += job[1];
            } else {
                time = jobs[index][0];
            }
        }

        return delay / jobsLen;
    }
}
