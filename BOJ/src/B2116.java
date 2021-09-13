import java.util.Scanner;

//0 - 5
//1 - 3
//2 - 4
public class B2116 {
    static int check_up(int d, int i, int[][] dice) {
        if (i == 0) {
            return dice[d][5];
        } else if (i == 1) {
            return dice[d][3];
        } else if (i == 2) {
            return dice[d][4];
        } else if (i == 3) {
            return dice[d][1];
        } else if (i == 4) {
            return dice[d][2];
        } else {
            return dice[d][0];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dice = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();
            }
        }
        // 1. 먼저 주사위를 세우는 방법 (1번 주사위를 어떤 숫자가 밑으로 갈지 정해야함)
        // 2. 회전하면서 4개의 면의 합 중에서 최대값을 찾음
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            int[][] up_down = new int[n][2];
            int down = dice[0][i];
            int up = check_up(0, i, dice);
            up_down[0][0] = down;
            up_down[0][1] = up;
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] == up) {
                        int down2 = up;
                        int up2 = check_up(j, k, dice);
                        up_down[j][0] = down2;
                        up_down[j][1] = up2;
                        up = up2;
                        down = down2;
                        break;
                    }
                }
            }
            int temp = 0;
            for (int j = 0; j < n; j++) {
                int max = 0;
                for (int k = 0; k < 6; k++) {
                    if (dice[j][k] != up_down[j][0] && dice[j][k] != up_down[j][1]) {
                        if (max < dice[j][k]) {
                            max = dice[j][k];
                        }
                    }
                }
                temp += max;
            }
            if (ans < temp) {
                ans = temp;
            }
        }
        System.out.println(ans);
    }
}
