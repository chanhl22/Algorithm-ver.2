//playtime = 11:44

class Solution85 {
    static int n;
    static int ans = 0;
    static boolean[] check;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        n = dungeons.length;
        check = new boolean[n];
        go(k, dungeons, 0);
        answer = ans;
        return answer;
    }

    private void go(int k, int[][] dungeons, int cnt) {
        if (ans < cnt) {
            ans = cnt;
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                if (k >= dungeons[i][0]) {
                    check[i] = true;
                    go(k - dungeons[i][1], dungeons,  cnt + 1);
                    check[i] = false;
                }
            }
        }
    }
}


public class P87946 {
    public static void main(String[] args) {
        Solution85 sol = new Solution85();
        int ans = 0;
        ans = sol.solution(80, new int[][]{{80,20},{50,40},{30,10}});
        System.out.println(ans);
    }
}