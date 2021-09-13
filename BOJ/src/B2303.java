import java.util.Scanner;

public class B2303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0; // 가장 큰 사람
        int ret = 0; // 1의 자리를 비교할 값
        for (int p = 0; p < n; p++) { //people
            int result = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = i+1; j < 5; j++) {
                    for (int k = j+1; k < 5; k++) {
                        int temp = a[p][i] + a[p][j] + a[p][k];
                        temp = temp % 10;
                        if (result < temp) {
                            result = temp;
                        }
                    }
                }
            }
            if (ret <= result) {
                ret = result;
                ans = p;
            }
        }
        System.out.println(ans+1);
    }
}
