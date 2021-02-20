package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
백준 2941번 크로아티아 알파벳
https://www.acmicpc.net/problem/2941

- 풀이법: HashMap 사용
  ㄴ time: 132
*/
public class Problem2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        Map<String, Integer> croatian = new HashMap<>();
        croatian.put("c=", 2);
        croatian.put("c-", 2);
        croatian.put("dz=", 3);
        croatian.put("d-", 2);
        croatian.put("lj", 2);
        croatian.put("nj", 2);
        croatian.put("s=", 2);
        croatian.put("z=", 2);

        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i + 1 < word.length()) {
                sb.setLength(0);
                sb.append(word.charAt(i))
                        .append(word.charAt(i + 1));

                if (i + 2 < word.length() && sb.toString().equals("dz")) {
                    sb.append(word.charAt(i + 2));
                }
            }

            if (croatian.containsKey(sb.toString())) {
                ans++;
                i += sb.length() - 1;
            } else {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
