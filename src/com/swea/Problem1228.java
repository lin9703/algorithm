package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since Feb 8, 2021
 * @author lin9703
 * @problem SWEA 1228번 암호문1
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD&categoryId=AV14w-rKAHACFAYD&categoryType=CODE&problemTitle=1228&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 18,560 
 * @time 111
 * @caution LinkedList 직접 구현 
 */
public class Problem1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			Node head = null;
			Node temp = null;
			for (int i = 0; i < 10; i++) {
				if (head == null) {
					temp = new Node(Integer.parseInt(st.nextToken()));
					head = new Node(0, temp);
					continue;
				}

				temp.link = new Node(Integer.parseInt(st.nextToken()));
				temp = temp.link;
			}

			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (x < 10) {
					Node point = head; // x 위치의 node 구하기
					int p = 0; // 현재 노드의 위치 from 0
					for (int j = 0; j < x; j++) {
						point = point.link;
						p++;
					}

					for (int j = 0; j < y; j++) {
						if (p < 10) {
							temp = point.link;
							point.link = new Node(Integer.parseInt(st.nextToken()));
							point = point.link;
							point.link = temp;
							p++;
						} else {
							st.nextToken();
						}
					}
				} else {
					for (int j = 0; j < y; j++) {
						st.nextToken();
					}
				}

			}

			// print
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				head = head.link;
				sb.append(head.data).append(" ");
			}
			sb.append("\n");

		}

		System.out.println(sb);
	}

	static class Node {
		int data;
		Node link;

		public Node(int data) {
			super();
			this.data = data;
		}

		public Node(int data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}

	}

}
