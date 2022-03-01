//playtime = 31:59

import java.util.Scanner;

public class B1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = -1;
        while (true) {
            String binary = Integer.toBinaryString(n);
            int count = 0;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    count++;
                }
            }
            if (count <= k) {
                System.out.println(ans + 1);
                break;
            } else {
                n++;
                ans++;
            }
        }
    }
}
