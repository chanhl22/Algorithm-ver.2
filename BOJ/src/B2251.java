//playtime = 01:39:22

import java.util.*;

public class B2251 {
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] water = new int[3]; //물통의 부피
        for (int i = 0; i < 3; i++) {
            water[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(water[2]);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        boolean[][] check = new boolean[201][201];
        check[0][0] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = water[2] - x - y;
            for (int k = 0; k < 6; k++) {
                int[] next = {x, y, z};
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;
                if (next[to[k]] > water[to[k]]) {
                    next[from[k]] = next[to[k]] - water[to[k]];
                    next[to[k]] -= next[from[k]];
                }
                if (check[next[0]][next[1]] == false) {
                    q.add(next[0]);
                    q.add(next[1]);
                    check[next[0]][next[1]] = true;
                    if (next[0] == 0) {
                        ans.add(next[2]);
                    }
                }
            }
        }
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
