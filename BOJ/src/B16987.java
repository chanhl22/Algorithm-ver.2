import java.util.Scanner;

public class B16987 {
    static int n;
    static int[] d; //Durability
    static int[] w; //weight

    static int go(int index) {
        if (index == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (d[i] <= 0) {
                    cnt += 1;
                }
            }
            return cnt;
        }
        if (d[index] <= 0) {
            return go(index + 1);
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int i = index;
            if (i == j) continue;
            if (d[j] > 0) {
                d[i] -= w[j];
                d[j] -= w[i];
                int temp = go(index + 1);
                if (temp > ans) {
                    ans = temp;
                }
                d[i] += w[j];
                d[j] += w[i];
            }
        }
        //현재 index를 제외한 나머지가 0이라면
        /*
        여기서 복잡하게 했는데 밑에 추가한 코드를 보면 깔끔하게 처리함
         */
        if (d[index] > 0) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (index == i) continue;
                if (d[i] > 0) {
                    ok = false;
                }
            }
            if (ok) {
                return go(index + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        System.out.println(go(0));
    }
}

//Best Solution
//import java.util.*;
//public class Main {
//    static int n;
//    static int[] s = new int[10];
//    static int[] w = new int[10];
//    static int go(int index) {
//        if (index == n) {
//            int cnt = 0;
//            for (int i=0; i<n; i++) {
//                if (s[i] <= 0) {
//                    cnt += 1;
//                }
//            }
//            return cnt;
//        }
//        if (s[index] <= 0) {
//            return go(index+1);
//        }
//        int ans = 0;
//        boolean ok = false;
//        for (int j=0; j<n; j++) {
//            int i = index;
//            if (i == j) continue;
//            if (s[j] > 0) {
//                ok = true;
//                // s[j]가 0보다 같거나 작다면 다음 함수를 호출하지 못한다. ok변수를 통해서 간단하게 해결할 수 있다.
//                s[i] -= w[j];
//                s[j] -= w[i];
//                int temp = go(index+1);
//                if (ans < temp) ans = temp;
//                s[i] += w[j];
//                s[j] += w[i];
//            }
//        }
//        if (!ok) {
//            return go(index+1);
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            s[i] = sc.nextInt();
//            w[i] = sc.nextInt();
//        }
//        System.out.println(go(0));
//    }
//}