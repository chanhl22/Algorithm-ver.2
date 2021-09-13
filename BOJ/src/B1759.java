import java.util.Arrays;
import java.util.Scanner;

public class B1759 {
    static boolean check(String password) {
        int mo = 0;
        int ja = 0;
        char[] x = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
		/*
		for (char x : password.toCharArray())
		*/
            if (x[i] == 'a' || x[i] == 'e' || x[i] == 'i' || x[i] == 'o' || x[i] == 'u')
                mo += 1;
            else
                ja += 1;
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        } else {
            return false;
        }
        //return mo >= 1 && ja >= 2;
    }

    static void go(int n, String[] alpha, String password, int i) {
        if (password.length() == n) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }
        if (i >= alpha.length) {
            return;
        }
        go(n, alpha, password + alpha[i], i + 1);
        go(n, alpha, password, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] alpha = new String[m];
        for (int i = 0; i < m; i++) {
            alpha[i] = sc.next();
        }

        Arrays.sort(alpha);
        go(n, alpha, "", 0);
    }
}		