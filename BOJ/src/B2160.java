import java.util.Scanner;

public class B2160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] a = new char[n * 5][7];
        for (int i = 0; i < n * 5; i++) {
            a[i] = sc.next().toCharArray();
        }
        int p1 = -1;
        int p2 = -1;
        int diff = -1;
        for (int k = 0; k < n; k++) {
            for (int l = k + 1; l < n; l++) {
                int temp = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 7; j++) {
                        if (a[i + 5 * k][j] != a[i + 5 * l][j]) {
                            temp++;
                        }
                    }
                }
                if (diff == -1 || diff > temp) {
                    diff = temp;
                    p1 = k+1;
                    p2 = l+1;
                }
            }
        }
        System.out.println(p1 + " " + p2);
    }
}
