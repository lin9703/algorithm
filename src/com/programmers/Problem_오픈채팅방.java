package com.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
프로그래머스 오픈채팅방
https://programmers.co.kr/learn/courses/30/lessons/42888

- 풀이법: 구현 (Map, List 이용)
  ㄴ 100 / 100
*/
public class Problem_오픈채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<String, String>();
        List<String> list = new ArrayList();
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (!split[0].equals("Leave"))
                map.put(split[1], split[2]);
        }

        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (split[0].equals("Enter")) {
                list.add(map.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].equals("Leave")) {
                list.add(map.get(split[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
