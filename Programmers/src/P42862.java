import java.util.*;

class Solution46 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] check = new int[n + 2]; //-1 : 없음, 1 : 여벌 있음, 0 : 본인만 있음
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (i == lost[j]) {
                    check[i] -= 1;
                }
            }
            for (int j = 0; j < reserve.length; j++) {
                if (i == reserve[j]) {
                    check[i] += 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (check[i] == -1) {
                if (check[i-1] == 1) {
                    check[i-1] -= 1;
                    check[i] += 1;
                } else if (check[i+1] == 1) {
                    check[i+1] -= 1;
                    check[i] += 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (check[i] != -1) {
                answer++;
            }
        }
        return answer;
    }
}

public class P42862 {
    public static void main(String[] args) {
        Solution46 sol = new Solution46();
        int ans = sol.solution(5, new int[]{2,4}, new int[]{1,3,5});
        System.out.println(ans);
    }
}
