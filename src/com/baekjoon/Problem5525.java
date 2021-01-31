package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
백준 5525번 IOIOI
https://www.acmicpc.net/problem/5525

- 처음 풀이: 투포인터 & String equals() -> 시간 초과
- 풀이법: 슬라이딩 윈도우 사용 -> 성공
    ㄴ 시간복잡도 O(n)
 */
public class Problem5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 숫자만 체크하면 되기 때문에 필요 없음
//        StringBuilder sb = new StringBuilder();
//        sb.append("I");
//        for (int i = 0; i < N; i++) {
//            sb.append("OI");
//        }
//        String p = sb.toString();
//        int pNum = p.length();
        int pNum = 1 + 2 * N;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        int result = 0;
        Deque<Character> deque = new ArrayDeque<>();
        if (pNum <= M) {
            int i = 0;
            while (i < M) {
                char s = S.charAt(i++);
                if (deque.isEmpty()) {
                    if (s == 'I') {
                        deque.addLast(s);
                    }
                } else if (deque.peekLast() == 'I') {
                    if (s == 'I') {
                        deque.clear();
                        deque.addLast('I');
                    } else {
                        deque.addLast(s);
                    }
                } else {
                    if (s == 'O') {
                        deque.clear();
                    } else {
                        deque.addLast(s);
                    }
                }

                if (deque.size() == pNum) {
                    result++;
                    deque.pollFirst();
                    deque.pollFirst();
                }
            }
        }

        System.out.println(result);
    }
}
