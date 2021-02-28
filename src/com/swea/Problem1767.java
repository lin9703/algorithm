package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since Feb 25, 2021
 * @author lin9703
 * @problem SWEA 1767번 프로세서 연결하기
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf&categoryId=AV4suNtaXFEDFAUf&categoryType=CODE&problemTitle=1767&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem 24,532
 * @time 124
 * @caution Backtracking 사용 (재귀 + Pruning)
 * ㄴ 실패 원인: 처음에 isVisitedCheck() 메소드에서 갈 수 있는지 체크 + 방문 표시 + 못 가면 방문 표시 초기화를 진행했다.
 *            이 과정에서 기존에 표시해둔 마킹도 초기화가 되어 문제 발생
 *            -> 갈 수 있는지 체크와 방문 표시 메소드를 분리 했더니 성공
 */
public class Problem1767 {
    static int N;
    static int[][] map;
    static List<Point> cores;
    static int[] dx = {-1, 1, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0};
    static int coreCnt;
    static int wireLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            cores = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                            cnt++;
                            continue;
                        } else {
                            cores.add(new Point(i, j));
                        }
                    }
                }
            }

            getCoresLen();

            coreCnt = 0;
            wireLen = Integer.MAX_VALUE;
            connection(0, 0, 0);

            ans.append("#").append(t).append(" ").append(wireLen).append("\n");
        }

        System.out.println(ans);
    }

    static class Point {
        int x;
        int y;
        int[] len = {0, 0, 0, 0, -2};

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void getCoresLen() {
        for (int i = 0; i < cores.size(); i++) {
            Point p = cores.get(i);
            int x = p.x;
            int y = p.y;
            int[] len = p.len;

            for (int j = 0; j < 4; j++) {
                boolean isConnect = true;
                int tempLen = 0;
                int nx = x + dx[j];
                int ny = y + dy[j];

                while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] == 1) {
                        isConnect = false;
                        break;
                    }

                    tempLen++;
                    nx += dx[j];
                    ny += dy[j];
                }

                if (isConnect) {
                    len[j] = tempLen;
                } else {
                    len[j] = -1;
                }
            }
        }
    }

    private static void connection(int idx, int cnt, int lenSum) {
        if ((cores.size() - idx + cnt) < coreCnt) return;
        if (idx == cores.size()) {
            if (coreCnt < cnt) {
                coreCnt = cnt;
                wireLen = lenSum;
            } else if (coreCnt == cnt) {
                coreCnt = cnt;
                wireLen = Math.min(wireLen, lenSum);
            }

            return;
        }

        Point p = cores.get(idx);
        int x = p.x;
        int y = p.y;
        int[] len = p.len;

        for (int i = 0; i < 5; i++) {
            if (len[i] != -1) {
                if (len[i] > 0) {
                    if (isVisitedCheck(x, y, i)) {
                        setStatus(x, y, i, 2);
                        connection(idx + 1, cnt + 1, lenSum + len[i]);
                        setStatus(x, y, i, 0);
                    }
                } else {
                    connection(idx + 1, cnt, lenSum);
                }
            }
        }
    }

    private static boolean isVisitedCheck(int x, int y, int i) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        while (nx > 0 && ny > 0 && nx < N - 1 && ny < N - 1) {
            if (map[nx][ny] != 0) {
                return false;
            }

            nx += dx[i];
            ny += dy[i];
        }

        return true;
    }

    private static void setStatus(int x, int y, int i, int n) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        while (nx > 0 && ny > 0 && nx < N - 1 && ny < N - 1) {
            map[nx][ny] = n;

            nx += dx[i];
            ny += dy[i];
        }
    }
}
