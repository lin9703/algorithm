package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 2304번 창고 다각형
https://www.acmicpc.net/problem/2304

- 풀이법: 제일 긴 길이의 기둥을 기준으로 양옆으로 구하기
  ㄴ time: 152
*/
public class Problem2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Stick> sticks = new ArrayList<>();
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sticks.add(new Stick(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));

            maxH = Math.max(maxH, sticks.get(i).h);
        }

        Collections.sort(sticks);

        int area = 0;
        int i = 0;
        int exH = 0;
        int exLoc = 0;
        int maxLoc = 0;
        while (true) {
            Stick temp = sticks.get(i++);

            if (exH < temp.h) {
                area += (temp.loc - exLoc) * exH;

                exLoc = temp.loc;
                exH = temp.h;
            }

            if (maxH == temp.h) {
                maxLoc = temp.loc;
                break;
            }
        }

        i = sticks.size() - 1;
        exH = 0;
        exLoc = 0;
        while (true) {
            Stick temp = sticks.get(i--);

            if (exH < temp.h) {
                area += (exLoc - temp.loc) * exH;

                exLoc = temp.loc;
                exH = temp.h;
            }

            if (maxH == temp.h) {
                area += (temp.loc - maxLoc + 1) * maxH;
                break;
            }
        }

        System.out.println(area);

    }

    static class Stick implements Comparable<Stick> {
        int loc;
        int h;

        public Stick(int loc, int h) {
            this.loc = loc;
            this.h = h;
        }

        @Override
        public int compareTo(Stick o) {
            return Integer.compare(this.loc, o.loc);
        }
    }


}
