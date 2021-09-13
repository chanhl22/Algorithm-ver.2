import java.util.Scanner;

public class B11170 {
    static int cal(int n, int m) {
        int ans = 0;
        for (int num = n; num <= m; num++) {
            if (num == 0) {
                ans++;
            }
            int temp = num;
            while (temp > 0) {
                if (temp % 10 == 0) {
                    ans++;
                }
                temp = temp / 10;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = 0;
            ans += cal(n,m);
            System.out.println(ans);
        }
    }
}

//Another Solution
//import java.util.Scanner;
//
//public class B11170 {
//    static int calc(int num) {
//        int ret = 0;
//        for (char c : String.valueOf(num).toCharArray()) {
//            if (c == '0'){
//                ret++;
//            }
//        }
//        return ret;
//    }
//
//    static int solve(int n, int m) {
//        int ret = 0;
//        for (int i = n; i <= m; i++) {
//            ret += calc(i);
//        }
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            System.out.println(solve(n,m));
//        }
//    }
//}