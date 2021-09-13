//import java.util.*;
//
//public class B1644 {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        boolean[] c = new boolean[n+1];
//        List<Integer> p = new ArrayList<Integer>();
//        for (int i=2; i<=n; i++) {
//            if (!c[i]) {
//                p.add(i);
//                for (int j=i*2; j<=n; j+=i) {
//                    c[j] = true;
//                }
//            }
//        }
//        int l=0;
//        int r=0;
//        int sum = p.size() == 0 ? 0 : p.get(0);
//        int ans = 0;
//
//        while (l <= r && r < p.size()) {
//            if (sum <= n) {
//                if (sum == n) {
//                    ans += 1;
//                }
//                r++;
//                if (r < p.size()) {
//                    sum += p.get(r);
//                }
//            } else {
//                sum -= p.get(l++);
//            }
//        }
//        System.out.println(ans);
//    }
//}

import java.util.Scanner;

public class B1644 {
    static final int MAX = 4000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] num = new boolean[MAX];
        int[] prime = new int[MAX + 1];
        for (int i = 2; i < MAX; i++) {
            if (num[i] == false) {
                for (int j = i + i; j < MAX; j += i) {
                    num[j] = true;
                }
            }
        }
        int j = 0;
        for (int i = 2; i < MAX; i++) {
            if (num[i] == false) {
                prime[j] = i;
                j++;
            }
        }
        int left = 0;
        int right = 0;
        int sum = prime[0];
        int ans = 0;
        while (left <= right && right < MAX) {
            if (sum < n) {
                right += 1;
                sum += prime[right];
            } else if (sum == n) {
                ans += 1;
                right += 1;
                sum += prime[right];
            } else if (sum > n) {
                sum -= prime[left];
                left += 1;
                if (left > right && left < n) {
                    right = left;
                    sum = prime[left];
                }
            }
        }
        System.out.println(ans);
    }
}

