import java.util.Scanner;

public class B3035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();
        char[][] a = new char[r][c];
        for (int i = 0; i < r; i++) {
            a[i] = sc.next().toCharArray();
        }
        char[][] ans = new char[r * zr][c * zc];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = i * zr; k < i * zr + zr; k++) {
                    for (int l = j * zc; l < j * zc + zc; l++) {
                        ans[k][l] = a[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < r * zr; i++) {
            for (int j = 0; j < c * zc; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}
