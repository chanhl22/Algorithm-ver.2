import java.util.Scanner;

public class B2992 {
    static boolean next(int[] a, int n) {
        int i = n - 1;
        while (i > 0 && a[i] <= a[i - 1]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }

        int j = n - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = n - 1;
        while (i < j) {
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] a = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            a[i] = n.charAt(i) - '0';
        }
        if (next(a, n.length())) {
            for (int i = 0; i < n.length(); i++) {
                System.out.print(a[i]);
            }
        } else {
            System.out.println(0);
        }
    }
}
