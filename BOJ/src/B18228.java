import java.util.Scanner;

public class B18228 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int penguin = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == -1) {
                penguin = i;
            }
        }
        int left_min = -1;
        for (int i = 0; i < penguin; i++) {
            if (left_min == -1 || left_min > a[i]) {
                left_min = a[i];
            }
        }
        int right_min = -1;
        for (int i = penguin + 1; i < n; i++) {
            if (right_min == -1 || right_min > a[i]) {
                right_min = a[i];
            }
        }
        System.out.println(right_min + left_min);
    }
}
