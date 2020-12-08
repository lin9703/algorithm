package com.practice;

import java.util.Stack;

public class QueueUsingTwoStack {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.push("A");
        queue.push("B");
        System.out.println(queue.pop());
        queue.push("C");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    static class QueueUsingStack {
        static Stack inputStack;
        static Stack outputStack;

        QueueUsingStack() {
            inputStack = new Stack();
            outputStack = new Stack();
        }

        void push(Object s) {
            inputStack.push(s);
        }

        Object pop() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(
                            inputStack.pop()
                    );
                }
            }
            return outputStack.pop();
        }

    }

}
