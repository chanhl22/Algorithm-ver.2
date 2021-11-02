//playtime = more than 3 hours

import java.util.ArrayList;
import java.util.Scanner;

public class B1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] use = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            use[i] = sc.nextInt();
        }
        ArrayList<Integer> m = new ArrayList<>();
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (!m.contains(use[i])) { //동일한 전기 용품 아님
                if (m.size() < n) { //멀티탭에 공간 있음
                    m.add(use[i]);
                } else { //멀티탭에 공간 없음
                    int[] check = new int[m.size()];
                    for (int j = 0; j < m.size(); j++) {
                        for (int l = i + 1; l <= k; l++) {
                            if (m.get(j) == use[l]) {
                                check[j] = l;
                                break;
                            }
                        }
                    }
                    boolean ok = false;
                    for (int j = 0; j < m.size(); j++) {
                        if (check[j] == 0) {
                            m.set(j, use[i]);
                            ok = true;
                            break;
                        }
                    }
                    if (ok){
                        ans++;
                        continue;
                    }
                    int max = 0;
                    int index = 0;
                    for (int j = 0; j < m.size(); j++) {
                        if (max < check[j]) {
                            max = check[j];
                            index = j;
                        }
                    }
                    m.set(index, use[i]);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

//Time out
//import java.util.Scanner;
//
//public class B1700 {
//    static int n;
//    static int k;
//    static int[] use;
//    static int ans = -1;
//
//    static boolean check(int[] m, int c) {
//        for (int i = 0; i < n; i++) {
//            if (m[i] == c) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    static void go(int index, int sum, int[] multitap) {
//        if (index == k) {
//            if (ans == -1 || ans > sum) {
//                ans = sum;
//            }
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (check(multitap, use[index])) {
//                go(index + 1, sum, multitap);
//            } else {
//                multitap[i] = use[index];
//                go(index + 1, sum + 1, multitap);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        k = sc.nextInt();
//        use = new int[k];
//        for (int i = 0; i < k; i++) {
//            use[i] = sc.nextInt();
//        }
//        int[] multitap = new int[n];
//        for (int i = 0; i < n; i++) {
//            multitap[i] = use[i];
//        }
//        go(2, 0, multitap);
//        System.out.println(ans);
//    }
//}
