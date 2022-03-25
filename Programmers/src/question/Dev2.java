package question;

import java.util.LinkedList;
import java.util.Queue;

class Dish {
    String menu;
    int time;

    public Dish(String menu, int time) {
        this.menu = menu;
        this.time = time;
    }
}

class Solution66 {


    public int solution(int n, String[] recipes, String[] orders) {
        int answer = 0;
        Queue<Dish>[] q = new Queue[n];
        for (int i = 0; i < n; i++) {
            q[i] = new LinkedList<>();
        }
        int orders_n = orders.length;
        String[][] o = new String[orders_n][2];
        for (int i = 0; i < orders_n; i++) {
            o[i] = orders[i].split(" ");
        }

        int recipes_n = recipes.length;
        String[][] r = new String[recipes_n][2];
        for (int i = 0; i < recipes_n; i++) {
            r[i] = recipes[i].split(" ");
        }

        int count = 1;
        int all = 0;
        while (true) {
            System.out.println();
            for (int i = 0; i < n; i++) {
                if (!q[i].isEmpty()) {
                    Dish pair = q[i].peek();
                    if (pair.time == count) {
                        q[i].remove();
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (q[i].isEmpty()) {
                    if (count >= Integer.parseInt(o[i][1])) {
                        int check = 0;//레시피 시간
                        for (int j = 0; j < recipes_n; j++) {
                            if (r[j][0].equals(o[i][0])) {
                                check = Integer.parseInt(r[j][1]);
                                break;
                            }
                        }
                        q[i].add(new Dish(o[i][0], Integer.parseInt(o[i][1]) + check));
                        all++;
                    }
                }
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (!q[i].isEmpty()) {
                    ok = false;
                }
            }
            if (ok && all == orders_n) {
                break;
            }
            count++;
        }
        return answer;
    }
}


public class Dev2 {
    public static void main(String[] args) {
        Solution66 sol = new Solution66();
        int ans = 0;
        ans = sol.solution(2, new String[]{"A 3","B 2"}, new String[]{"A 1","A 2","B 3","B 4"});
        System.out.println(ans);
    }
}