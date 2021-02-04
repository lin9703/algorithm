package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 7568번 덩치
https://www.acmicpc.net/problem/7568

- 풀이법: 브루트포스 - for문 이용
- 시간: 136
*/
public class Problem7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            persons.add(new Person(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int rank = 1;
            Person person = persons.get(i);

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                Person temp = persons.get(j);
                if ((person.weight < temp.weight) &&
                        (person.tall < temp.tall)) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }

    static class Person {
        int weight;
        int tall;

        public Person(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
        }
    }

}
