package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since Feb 4, 2021
 * @author lin9703
 * @problem SWEA 1225번 암호생성기
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=1225&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 21,600
 * @time 125
 * @caution Queue 사용 
 */
public class Problem1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();

		String line = null;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			st = new StringTokenizer(line);
			int t = Integer.parseInt(st.nextToken());

			queue.clear();

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			int reductionNum = 1;
			while (true) {
				if (reductionNum > 5) {
					reductionNum = 1;
				}
				int temp = queue.poll() - reductionNum++;
				if (temp <= 0) {
					temp = 0;
					queue.offer(temp);
					break;
				}
				queue.offer(temp);
			}

			// print
			sb.append("#").append(t).append(" ");
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
}
