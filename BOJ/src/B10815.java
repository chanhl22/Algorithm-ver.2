//playtime = 10:10
//이분 탐색으로 풀어도 됨

import java.util.HashSet;
import java.util.Scanner;

public class B10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int len = set.size();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            set.add(sc.nextInt());
            if (len == set.size()) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
                len = set.size();
            }
        }
        System.out.println(sb.toString());
    }
}