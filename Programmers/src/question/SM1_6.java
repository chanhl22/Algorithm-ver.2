package question;

import java.util.Scanner;

public class SM1_6 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 10000000;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int z = sc.nextInt();
            arr[x][y] = z;
            arr[y][x] = z;
        }
        int[] diamond = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt();
            diamond[x] = y;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int sum = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (diamond[i] - arr[0][i] * 2 > sum) {
                sum = diamond[i] - arr[0][i] * 2;
                ans = i;
            }
        }
        System.out.println(ans + " " + sum);
    }
}

//input
//4 3
//1 2 3
//1 3 1
//3 4 3
//4 10
//2 7
//3 4