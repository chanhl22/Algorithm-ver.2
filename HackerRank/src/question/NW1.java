package question;

class Solution30 {
    static int n;
    static int m;
    static int t;
    static int k;
    static int ans = 0;
    static int[] record;

    static void go (int index, int sum) {
        if (index == n) {
            if (sum == m) {
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    int temp = 0;
                    for (int j = 0; j < t;  j++) {
                        if (i + j >= n) continue;
                        temp += record[i+j];
                    }
                    if (temp > k) {
                        ok = false;
                    }
                }
                if (ok) {
                    ans++;
                }
            }
            return;
        }
        for (int i = 0; i <= m; i++) {
            record[index] = i;
            go(index + 1, sum + i);
            record[index] = -1;
        }
    }

    public int solution(int N, int money, int T, int K) {
        int answer = -1;
        n = N;
        m = money;
        t =T;
        k = K;
        record = new int[N];
        for (int i = 0; i < N; i++) {
            record[i] = -1;
        }
        go(0,0);
        answer = ans;
        return answer;
    }
}


public class NW1 {
    public static void main(String[] args) {
        Solution30 sol = new Solution30();
        int ans = 0;
        ans = sol.solution(2,4,1,3);
        System.out.println(ans);
    }
}