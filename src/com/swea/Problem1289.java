package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SW Expert Academy 5525번 원재의 메모리 복구하기
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=%EC%9B%90%EC%9E%AC%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
public class Problem1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            String N = st.nextToken();

            int result = 0;
            boolean isOne = false;
            for (int j = 0; j < N.length(); j++) {
                char c = N.charAt(j);
                if (c == '1' && !isOne) {
                    isOne = true;
                    result++;
                } else if (c == '0' && isOne) {
                    isOne = false;
                    result++;
                }
            }

            System.out.printf("#%d %d\n", i, result);
        }
    }
}
