//playtime = 05:35

import java.util.Scanner;

public class B1855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int k, n;
        k = sc.nextInt();
        String str = sc.next();
        n = str.length();
        for (int i = 0; i < k; i++)
            for (int j = 0; j < n / k; j++) {
                sb.append(str.charAt(j % 2 == 0 ? j * k + i : j * k + k - 1 - i));
            }
        System.out.println(sb);
    }
}
