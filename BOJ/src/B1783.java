import java.util.Scanner;

public class B1783 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = 0;
        if (n == 1) {
        } else if (n == 2) {
            max = (m - 1) / 2;
            max = max > 3 ? 3 : max;
        } else if (m < 7) {
            max = m - 1;
            max = max > 3 ? 3 : max;
        } else {
            max = 4 + m - 7;
        }
        System.out.println(max + 1);
    }
}

// reference : https://do-rang.tistory.com/70