package com.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class PrioirityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());

        q1.add(7);
        q1.add(1);
        q1.add(2);

        System.out.println(q1.poll());
        System.out.println(q1.peek());
        System.out.println(q1.peek());

        PriorityQueue<Student> q2 = new PriorityQueue<>(1,
                (Student s1, Student s2) -> s1.age >= s2.age ? 1 : -1);
        q2.add(new Student("a", 20));
        q2.add(new Student("b", 1));
        q2.add(new Student("c", 79));
        q2.add(new Student("d", 22));
        q2.add(new Student("e", 10));
        q2.add(new Student("f", 5));
        q2.add(new Student("g", 5));


        while (!q2.isEmpty())
            System.out.println(q2.poll());


    }

    static class Student implements Comparable<Student> {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student target) {
            return this.age <= target.age ? 1 : -1;
        }

        public String toString() {
            return name + ": " + age;
        }


    }
}
