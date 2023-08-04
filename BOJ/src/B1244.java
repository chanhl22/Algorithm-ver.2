/**
 * playtime = 28:38
 */

import java.util.Scanner;

public class B1244 {
    private static int n;
    private static int[] switches;
    private static int m;
    private static int[][] students;

    public static void main(String[] args) {
        input();
        updateSwitches();

        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        switches = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            switches[i] = sc.nextInt();
        }
        m = sc.nextInt();
        students = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                students[i][j] = sc.nextInt();
            }
        }
    }

    private static void updateSwitches() {
        for (int i = 0; i < m; i++) {
            if (students[i][0] == 1) {
                boy(students[i][1]);
            } else {
                girl(students[i][1]);
            }
        }
    }

    private static void boy(int number) {
        for (int i = number; i <= n; i += number) {
            turnOnOff(i);
        }
    }

    private static void girl(int number) {
        turnOnOff(number);

        int index = 1;
        while (true) {
            if (number - index < 1 || number + index > n) {
                break;
            }

            if (switches[number - index] != switches[number + index]) {
                break;
            }

            turnOnOff(number - index);
            turnOnOff(number + index);
            index++;
        }
    }

    private static void turnOnOff(int i) {
        if (switches[i] == 1) {
            switches[i] = 0;
        } else {
            switches[i] = 1;
        }
    }
}
