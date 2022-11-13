//playtime = 2:26

class Solution87389 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}


public class P87389 {
    public static void main(String[] args) {
        Solution87389 sol = new Solution87389();
//        int ans = sol.solution(10);
        int ans = sol.solution(12);
        System.out.println(ans);
    }
}