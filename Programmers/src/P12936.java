//playtime = 2:11:05
//일반적인 순열로 풀면 시간초과

import java.util.ArrayList;

class Solution100 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remind = k - 1;

        while (i < n) {
            factorial = factorial / (n - i);
            int value = (int) (remind / factorial);
            answer[i] = list.get(value);
            i++;
            list.remove(value);
            remind = remind % factorial;
        }
        return answer;
    }
}

public class P12936 {
    public static void main(String[] args) {
        Solution100 sol = new Solution100();
        int[] ans = sol.solution(3, 5);
        System.out.println(ans);
    }
}