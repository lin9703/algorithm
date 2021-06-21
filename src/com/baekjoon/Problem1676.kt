package com.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.min

/*
백준 1676번 팩토리얼 0의 개수
https://www.acmicpc.net/problem/1676

- 풀이법: 수학
  ㄴ time: 92
*/
fun main() {
    val input = BufferedReader(InputStreamReader(System.`in`))
    val N = Integer.parseInt(input.readLine())

    val numCount = Array(6) { 0 }
    for (num in 2..N) {
        var temp = num

        while (true) {
            var divisor = -1
            if (temp.rem(5) == 0) {
                divisor = 5
            } else if (temp.rem(2) == 0) {
                divisor = 2
            }

            when (divisor) {
                -1 -> break
                else -> {
                    temp /= divisor
                    numCount[divisor]++
                }
            }
        }
    }

    val twoCount = numCount[2]
    val fiveCount = numCount[5]

    val zeroCount = min(twoCount, fiveCount)

    println(zeroCount)

}
