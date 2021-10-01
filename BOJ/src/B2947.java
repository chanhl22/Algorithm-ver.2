import java.util.Scanner;

public class B2947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                boolean ok = false;
                if (a[j - 1] > a[j]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    ok = true;
                }
                if (ok) {
                    for (int k = 0; k < 5; k++) {
                        System.out.print(a[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
