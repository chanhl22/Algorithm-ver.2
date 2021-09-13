import java.util.Arrays;
import java.util.Scanner;

public class B3047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        String s = sc.next();
        Arrays.sort(arr);
        for (int i = 0; i < 3; i++) {
            if (s.charAt(i) == 'A') {
                System.out.print(arr[0] + " ");
            } else if (s.charAt(i) == 'B') {
                System.out.print(arr[1] + " ");
            } else if (s.charAt(i) == 'C') {
                System.out.print(arr[2] + " ");
            }
        }
    }
}
