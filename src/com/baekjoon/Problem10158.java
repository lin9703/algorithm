package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 10158번 개미
https://www.acmicpc.net/problem/10158

- 첫 번째 풀이법: while문, if문 이용하여 한칸 씩 가게 구현 (시간초과)
  ㄴ 극에 가면 방향 바꾸게 구현 (fail)
  ㄴ 맨 마지막에 극까지 안 가는 경우 처리 (시간초과)
- 두 번째 풀이법: p, q는 +1씩 증가하고 limit 값이 넘으면 0으로 돌아가는 법칙 이용 (시간초과 및 fail)
  ㄴ 시간초과: Java11 -> Java8로 변경
  ㄴ fail: 변수 잘못 입력
  ㄴ time: 76
*/
public class Problem10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        // 첫 번째 풀이법
//        t %= w * h; // 반복 구간 삭제
//        int dx = 1, dy = 1;
//        int now = 0;
//        int n = 0;
//        while (now < t) {
//            if (p == w || p == 0) dx *= -1;
//            if (q == h || q == 0) dy *= -1;
//
//            if (dx > 0 && dy > 0) {
//                n = Math.min(w - p, h - q);
//            } else if (dx > 0 && dy < 0) {
//                n = Math.min(w - p, q);
//            } else if (dx < 0 && dy > 0) {
//                n = Math.min(p, h - q);
//            } else if (dx < 0 && dy < 0) {
//                n = Math.min(p, q);
//            }
//
//            n = Math.min(n, t - now);
//            p += n * dx;
//            q += n * dy;
//            now += n;
//        }

        // 두 번째 풀이법
        p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);

        if (p > w) p = 2 * w - p;
        if (q > h) q = 2 * h - q;

        System.out.println(p + " " + q);
    }

}
