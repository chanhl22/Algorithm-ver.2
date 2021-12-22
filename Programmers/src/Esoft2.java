import java.util.ArrayList;

class Solution70 {
    static int ans;
    static int n;
    static int m;
    static ArrayList<Integer> a;

    public int solution(int[][] needs, int r) {
        int answer = 0;
        n = needs.length;
        m = needs[0].length;
        a = new ArrayList<>();
        go(0, 0, r, needs);
        answer = ans;
        return answer;
    }

    private void go(int cnt, int start, int r, int[][] needs) {
        if (cnt == r) {
            int ret = check(needs);
            if (ans < ret) {
                ans = ret;
            }
            return;
        }
        for (int i = start; i < m; i++) {
            a.add(i);
            go(cnt + 1, i + 1, r, needs);
            a.remove(Integer.valueOf(i));
        }
    }

    private int check(int[][] needs) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < m; j++) {
                if (needs[i][j] == 1) {
                    if (!a.contains(j)) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                ans++;
            }
        }
        return ans;
    }
}


public class Esoft2 {
    public static void main(String[] args) {
        Solution70 sol = new Solution70();
        int ans = 0;
//        ans = sol.solution(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2);
//        ans = sol.solution(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, 3);
//        ans = sol.solution(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {0, 1, 1, 0}, {0, 0, 1, 1}}, 2);
//        ans = sol.solution(new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}}, 2);
//        ans = sol.solution(new int[][]{{1, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 1, 0, 1}, {1, 0, 0, 1, 0}, {1, 1, 1, 0, 0}}, 3);
//        ans = sol.solution(new int[][]{{1, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 1, 0, 1}, {1, 0, 0, 1, 0}, {1, 1, 1, 0, 0}}, 3);
        ans = sol.solution(new int[][]{{1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 1}}, 4);
        System.out.println(ans);
    }
}