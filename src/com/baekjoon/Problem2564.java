package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2564번 경비원
https://www.acmicpc.net/problem/2564

- 풀이법: 구현
  ㄴ time: 80
*/
public class Problem2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        int column = Integer.parseInt(tokenizer.nextToken());
        int row = Integer.parseInt(tokenizer.nextToken());
        int circumference = 2 * (column + row);

        int storeNum = Integer.parseInt(input.readLine());

        int[][] storeInfo = new int[storeNum + 1][2];
        for (int storeIdx = 0; storeIdx <= storeNum; storeIdx++) {
            tokenizer = new StringTokenizer(input.readLine());
            storeInfo[storeIdx][0] = Integer.parseInt(tokenizer.nextToken());
            storeInfo[storeIdx][1] = Integer.parseInt(tokenizer.nextToken());
        }

        int[][] storeLoc = new int[storeNum + 1][2];
        for (int storeIdx = 0; storeIdx <= storeNum; storeIdx++) {
            switch (storeInfo[storeIdx][0]) {
                case 1:
                    storeLoc[storeIdx][0] = 0;
                    storeLoc[storeIdx][1] = storeInfo[storeIdx][1];
                    break;
                case 2:
                    storeLoc[storeIdx][0] = row;
                    storeLoc[storeIdx][1] = storeInfo[storeIdx][1];
                    break;
                case 3:
                    storeLoc[storeIdx][0] = storeInfo[storeIdx][1];
                    storeLoc[storeIdx][1] = 0;
                    break;
                case 4:
                    storeLoc[storeIdx][0] = storeInfo[storeIdx][1];
                    storeLoc[storeIdx][1] = column;
                    break;
            }
        }

        int[] house = storeLoc[storeNum];
        int minDifferenceSum = 0;
        for (int storeIdx = 0; storeIdx < storeNum; storeIdx++) {
            int rowDifference = Math.abs(house[0] - storeLoc[storeIdx][0]);
            int columnDifference = Math.abs(house[1] - storeLoc[storeIdx][1]);

            if (rowDifference == row) {
                int tempDifference = rowDifference + house[1] + storeLoc[storeIdx][1];
                minDifferenceSum += Math.min(tempDifference, circumference - tempDifference);
            } else if (rowDifference == row || columnDifference == column) {
                int tempDifference = columnDifference + house[0] + storeLoc[storeIdx][0];
                minDifferenceSum += Math.min(tempDifference, circumference - tempDifference);
            } else {
                minDifferenceSum += rowDifference + columnDifference;
            }
        }

        System.out.println(minDifferenceSum);

    }
}
