import java.util.Scanner;

public class B1731 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int abs = Math.abs(arr[0] - arr[1]);
        if (abs == Math.abs(arr[1] - arr[2])) {
            System.out.println(arr[n - 1] + abs);
        } else {
            int next = arr[1] / arr[0];
            System.out.println(arr[n - next]);
        }
    }
}
