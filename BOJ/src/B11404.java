//playtime = 26:58

import java.util.Scanner;

public class B11404 {
    static int INF = 100000000;
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            if (map[s][e] == INF || map[s][e] > cost) {
                map[s][e] = cost;
            }
        }
        floydWarshall();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }
}

//import java.io.*;
//import java.util.*;
//
///**
// *
// * @author s_cheol.park
// * https://www.acmicpc.net/problem/11404
// * 플로이드
// * 플로이드워셜알고리즘
// */
//
//public class B11404 {
//
//    static int N, M;
//    static int [][] Map;
//    static StringBuffer Answer;
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        StringTokenizer st;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        N = Integer.parseInt(br.readLine());
//        M = Integer.parseInt(br.readLine());
//
//        Map = new int [N + 1] [N + 1];
//
//        int a, b, c;
//        for(int i = 1 ; i <= M ;i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//            c = Integer.parseInt(st.nextToken());
//
//            if(Map[a][b] == 0 || Map[a][b] > c) {
//                Map[a][b] = c;
//            }
//        }
//
//        // j > k 를 i 를 이용하여 갈것인가를 판단한다.
//        for(int i = 1 ; i <= N ;i++) {
//            for(int j = 1 ; j <= N ;j++) {
//                for(int k = 1 ; k <= N ;k++) {
//                    if(j != k && Map[j][i] != 0 && Map[i][k] != 0) {
//                        if(Map[j][k] == 0 || Map[j][k] > Map[j][i] + Map[i][k]) {
//                            Map[j][k] = Map[j][i] + Map[i][k];
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i = 1 ; i <= N ;i++) {
//            Answer = new StringBuffer();
//            for(int j = 1 ; j <= N ;j++) {
//                Answer.append(Map[i][j] + " ");
//            }
//            bw.write(Answer + "\n");
//        }
//
//        bw.flush();
//        bw.close();
//    }
//}