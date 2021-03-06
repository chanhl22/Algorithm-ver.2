//playtime = more than 3 hours

import java.util.Scanner;

public class B11049 {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = sc.nextInt();
            col[i] = sc.nextInt();
        }
        int[][] d = new int[n][n];
        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                d[i][j] = INF;
                for (int k = i; k < j; k++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k + 1][j] + row[i] * col[k] * col[j]);
                }
            }
        }
        System.out.println(d[0][n - 1]);
    }
}

//Another Solution
//import java.io.*;
//import java.util.*;
//
///**
// *
// * @author s_cheol.park
// * https://www.acmicpc.net/problem/11049
// * 행렬곱셈순서 - DP (사선)
// * 시간복잡도 O(N*N*N)
// */
//
//public class B11049 {
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        StringTokenizer st;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int MatrixR [] = new int [N+1];
//        int MatrixC [] = new int [N+1];
//        int D [][] = new int [N+1+1][N+1+1];
//        final int Inf = Integer.MAX_VALUE;
//        // 입력
//        for(int i = 1 ; i <= N ; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            MatrixR[i] = Integer.parseInt(st.nextToken());
//            MatrixC[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // 점화식을 이용한 계산
//        // D[i][j] = i 번 Matrix 에서 j 번 매트릭스까지 곱할때 최소 연산값
//        for(int i = N-1 ; i >= 1 ; i--) { // from
//            for(int j = i + 1 ; j <= N ; j++) { // to
//                D[i][j] = Inf;
//                for(int k = i ; k <= j ; k++) { // 자르는 위치
//                    D[i][j] = Math.min(D[i][j], D[i][k]+D[k+1][j]+MatrixR[i]*MatrixC[k]*MatrixC[j]);
//                }
//            }
//        }
//
//        // 정답찾기
//        bw.write(D[1][N] + "\n");
//        bw.flush();
//        bw.close();
//
//    }
//}
