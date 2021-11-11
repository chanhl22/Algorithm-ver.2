import java.util.Arrays;

class Solution61 {
    static int s = 0;
    static int a = -1;

    static void go(int index, int sum, int n, int m, int[] mmr, int start) {
        if (index == m) {
            //sum은 뽑은 4개의 값
            //s는 전체의 합
            int temp = s - sum; //전체에서 뽑은 4개 제거한 합
            if (a == -1 || a > Math.abs(temp - sum)) {
                a = Math.abs(temp - sum);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            go(index + 1, sum + mmr[i], n, m, mmr, i + 1);
        }
    }

    public int solution(int[] mmr) {
        s = 0;
        for (int i = 0; i < mmr.length; i++) {
            s += mmr[i];
        }
        //Arrays.sort(mmr);
        int n = mmr.length;
        int m = mmr.length / 2;
        go(0, 0, n, m, mmr, 0);
        int answer = a;
        return answer;
    }
}

public class Bagle3 {
    public static void main(String[] args) {
        Solution61 sol = new Solution61();
        int ans = 0;
        //ans = sol.solution(new int[]{33, 56, 93, 31, 18, 10, 41, 93});
        ans = sol.solution(new int[]{5, 56, 30, 49, 38, 63});
        System.out.println(ans);
    }
}