import java.util.Scanner;

public class H4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[3];
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                ans1++;
            } else if (a[i] < b[i]) {
                ans2++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
