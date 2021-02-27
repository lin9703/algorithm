package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since Feb 26, 2021
 * @author lin9703
 * @problem SWEA 4698번 테네스의 특별한 소수
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRuoqCKkE0DFAXt&categoryId=AWRuoqCKkE0DFAXt&categoryType=CODE&problemTitle=4698&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 91,140
 * @time 494
 * @caution 첫 번째 풀이법 - for문으로 루트값까지 돌아서 소수 구하기 (시간초과)
 * 두 번째 풀이법 - 1부터 n까지 isPrime 배열 만들어서 저장 - for 문으로 소수의 배수는 다 false (성공)
 */
public class Problem4698 {
    private static int n;
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = 1000001;
        isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        judgePrime();

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            //int cnt = firstLogic(D, A, B);

            int cnt = secondLogic(D, A, B);

            sb.append("#").append(t).append(" ");
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void judgePrime() {
        isPrime[1] = false;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) continue;

            for (int j = 2; i * j < n; j++)
                isPrime[i * j] = false;
        }
    }

    private static int secondLogic(int d, int a, int b) {
        int cnt = 0;

        for (int i = a; i <= b; i++) {
            if (isPrime[i] && String.valueOf(i).contains(String.valueOf(d)))
                cnt++;
        }

        return cnt;
    }

    private static int firstLogic(int d, int a, int b) {
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                if (String.valueOf(i).contains(String.valueOf(d))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
