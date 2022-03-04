//playtime = 17:32

import java.util.HashSet;
import java.util.Scanner;

public class B5568 {
    static int n;
    static int k;
    static String[] card;
    static HashSet<String> set;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        card = new String[n];
        for (int i = 0; i < n; i++) {
            card[i] = sc.next();
        }
        set = new HashSet<>();
        check = new boolean[n];
        go(0, "");
        System.out.println(set.size());
    }

    private static void go(int index, String temp) {
        if (index == k) {
            set.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                go(index + 1, temp + card[i]);
                check[i] = false;
            }
        }
    }
}
