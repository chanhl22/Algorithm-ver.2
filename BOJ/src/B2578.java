import java.util.Scanner;

public class B2578 {
    static int check_row(int[][] arr) {
        int ret = 0;
        for (int i = 0; i < 5; i++) {
            int zero = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 0) {
                    zero++;
                }
            }
            if (zero == 5) {
                ret++;
            }
        }
        return ret;
    }

    static int check_col(int[][] arr) {
        int ret = 0;
        for (int i = 0; i < 5; i++) {
            int zero = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == 0) {
                    zero++;
                }
            }
            if (zero == 5) {
                ret++;
            }
        }
        return ret;
    }

    static int check_diagonal(int[][] arr) {
        int ret = 0;
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == 0) {
                zero++;
            }
        }
        if (zero == 5) {
            ret++;
        }
        zero = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] == 0) {
                zero++;
            }
        }
        if (zero == 5) {
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= 25; i++) {
            int num = sc.nextInt();
            int ans = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (arr[j][k] == num) {
                        arr[j][k] = 0;
                    }
                }
            }
            ans += check_row(arr);
            ans += check_col(arr);
            ans += check_diagonal(arr);
            if (ans >= 3) {
                System.out.println(i);
                break;
            }
        }
    }
}
