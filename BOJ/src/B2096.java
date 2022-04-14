//playtime = 17:27

import java.util.Scanner;

public class B2096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] dpMAX = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dpMAX[0][i] = map[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMAX[i][j] = Math.max(dpMAX[i - 1][j], dpMAX[i - 1][j + 1]) + map[i][j];
                } else if (j == 1) {
                    dpMAX[i][j] = Math.max(Math.max(dpMAX[i - 1][j], dpMAX[i - 1][j + 1]), dpMAX[i - 1][j - 1]) + map[i][j];
                } else if (j == 2) {
                    dpMAX[i][j] = Math.max(dpMAX[i - 1][j], dpMAX[i - 1][j - 1]) + map[i][j];
                }
            }
        }

        int[][] dpMIN = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dpMIN[0][i] = map[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMIN[i][j] = Math.min(dpMIN[i - 1][j], dpMIN[i - 1][j + 1]) + map[i][j];
                } else if (j == 1) {
                    dpMIN[i][j] = Math.min(Math.min(dpMIN[i - 1][j], dpMIN[i - 1][j + 1]), dpMIN[i - 1][j - 1]) + map[i][j];
                } else if (j == 2) {
                    dpMIN[i][j] = Math.min(dpMIN[i - 1][j], dpMIN[i - 1][j - 1]) + map[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (dpMAX[n - 1][i] > max) {
                max = dpMAX[n - 1][i];
            }
        }
        int min = -1;
        for (int i = 0; i < 3; i++) {
            if (min == -1 || dpMIN[n - 1][i] < min) {
                min = dpMIN[n - 1][i];
            }
        }
        System.out.println(max + " " + min);
    }
}
