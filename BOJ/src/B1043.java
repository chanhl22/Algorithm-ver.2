//playtime = 49:56

import java.util.Scanner;

public class B1043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t_cnt = sc.nextInt();
        int[] truth = new int[t_cnt];
        boolean[] people = new boolean[n + 1];
        for (int i = 0; i < t_cnt; i++) {
            truth[i] = sc.nextInt();
            people[truth[i]] = true;
        }
        int[][] party = new int[m][];
        for (int i = 0; i < m; i++) {
            int p_cnt = sc.nextInt();
            party[i] = new int[p_cnt];
            boolean ok = false;
            for (int j = 0; j < p_cnt; j++) {
                party[i][j] = sc.nextInt();
                if (check(truth, party[i][j])) {
                    ok = true;
                }
            }
            if (ok) {
                for (int j = 0; j < p_cnt; j++) {
                    people[party[i][j]] = true;
                }
            }
        }

        // 반례를 위한 작업
        /*
        4 5
        1 1
        1 1
        1 2
        1 3
        2 4 2
        2 4 1

        answer : 1
         */
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                boolean ok = false;
                int len = party[i].length;
                for (int j = 0; j < len; j++) {
                    if (check(truth, party[i][j]) || people[party[i][j]] == true) {
                        ok = true;
                    }
                }
                if (ok) {
                    for (int j = 0; j < len; j++) {
                        people[party[i][j]] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int len = party[i].length;
            boolean ok = false;
            for (int j = 0; j < len; j++) {
                if (people[party[i][j]] == true) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int[] truth, int party) {
        for (int i : truth) {
            if (party == i) {
                return true;
            }
        }
        return false;
    }
}
