/**
 * playtime = 13:49
 */

import java.util.Scanner;

public class B9291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int index = 1;
        while (t-- > 0) {
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            boolean flag = true;
            for (int i = 0; i < 9; i++) {
                boolean[] check = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    if (!check[map[i][j]]) {
                        check[map[i][j]] = true;
                    } else {
                        flag = false;
                    }
                }
            }

            for (int j = 0; j < 9; j++) {
                boolean[] check = new boolean[10];
                for (int i = 0; i < 9; i++) {
                    if (!check[map[i][j]]) {
                        check[map[i][j]] = true;
                    } else {
                        flag = false;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    boolean[] check = new boolean[10];
                    for (int k = i * 3; k < i * 3 + 3; k++) {
                        for (int l = j * 3; l < j * 3 + 3; l++) {
                            if (!check[map[k][l]]) {
                                check[map[k][l]] = true;
                            } else {
                                flag = false;
                            }
                        }
                    }
                }
            }

            if (flag) {
                System.out.println("Case " + index + ": CORRECT");
            } else {
                System.out.println("Case " + index + ": INCORRECT");
            }

            if (t != 0) {
                sc.nextLine();
                index++;
            }
        }
    }
}
