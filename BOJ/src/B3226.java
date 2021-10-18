import java.util.Scanner;

public class B3226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String[] str = sc.next().split(":");
            int[] time_s = new int[2];
            for (int j = 0; j < 2; j++) {
                time_s[j] = Integer.parseInt(str[j]);
            }
            int all = sc.nextInt();
            int[] time_e = new int[2];
            if (time_s[1] + all >= 60) {
                time_e[0] = time_s[0] + 1;
                time_e[1] = time_s[1] + all - 60;
            } else {
                time_e[0] = time_s[0];
                time_e[1] = time_s[1] + all;
            }
//            if (time_s[0] >= 7 && time_s[0] < 19 && time_e[0] >= 7 && time_e[0] < 19) {
//                ans += all * 10;
//            } else if (time_s[0] >= 7 && time_s[0] < 19 && (time_e[0] < 7 || time_e[0] >= 19)) {
//                ans += (60 - time_s[1]) * 10;
//                ans += (all - (60 - time_s[1])) * 5;
//            } else if ((time_s[0] < 7 || time_s[0] >= 19) && time_e[0] >= 7 && time_e[0] < 19) {
//                ans += (60 - time_s[1]) * 5;
//                ans += (all - (60 - time_s[1])) * 10;
//            } else {
//                ans += all * 5;
//            }
            if (time_s[0] == 6 && time_e[0] == 7) {
                ans += (60 - time_s[1]) * 5;
                ans += (all - (60 - time_s[1])) * 10;
            } else if (time_s[0] == 18 && time_e[0] == 19) {
                ans += (60 - time_s[1]) * 10;
                ans += (all - (60 - time_s[1])) * 5;
            } else {
                if (time_s[0] >= 7 && time_s[0] < 19) {
                    ans += all * 10;
                } else {
                    ans += all * 5;
                }
            }
        }
        System.out.println(ans);
    }
}
