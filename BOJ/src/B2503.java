import java.util.Scanner;

public class B2503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] num = new String[t];
        int[] s = new int[t];
        int[] b = new int[t];
        for (int i = 0; i < t; i++) {
            num[i] = sc.next();
            s[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || i == k || j == k) continue;
                    boolean ok = true;
                    for (int l = 0; l < t; l++) {
                        int strike = 0;
                        int ball = 0;
                        if (i == num[l].charAt(0) - '0') {
                            strike++;
                        }else if(i == num[l].charAt(1) - '0' || i == num[l].charAt(2) - '0'){
                            ball++;
                        }
                        if (j == num[l].charAt(1) - '0') {
                            strike++;
                        }else if(j == num[l].charAt(0) - '0' || j == num[l].charAt(2) - '0'){
                            ball++;
                        }
                        if (k == num[l].charAt(2) - '0') {
                            strike++;
                        }else if(k == num[l].charAt(0) - '0' || k == num[l].charAt(1) - '0'){
                            ball++;
                        }
                        if(strike != s[l] || ball != b[l]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
