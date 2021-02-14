package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
백준 1991번 트리 순회
https://www.acmicpc.net/problem/1991

- 풀이법: 트리 노드 구현
  ㄴ time: 128
*/
public class Problem1991 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>(N);
        for (int i = 'A'; i < 'A' + N; i++) {
            nodes.add(new Node((char) i));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Node temp = nodes.get(st.nextToken().charAt(0) - 65);
            char c;
            if (!((c = st.nextToken().charAt(0)) == '.')) {
                temp.left = nodes.get(c - 65);
            }
            if (!((c = st.nextToken().charAt(0)) == '.')) {
                temp.right = nodes.get(c - 65);
            }
        }

        preorder(nodes.get(0));
        sb.append("\n");

        inorder(nodes.get(0));
        sb.append("\n");

        postorder(nodes.get(0));

        System.out.println(sb);
    }

    private static void preorder(Node node) {
        if (node == null) return;

        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }
}
