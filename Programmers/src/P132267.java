//playtime = 32:29

class Solution132267 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int change = a;
        int remainder = 0;
        int total = n;

        while (total >= a) {
            remainder = total % a;
            change = total / a;
            answer += change * b;
            total = change * b + remainder;
        }

        return answer;
    }
}


public class P132267 {
    public static void main(String[] args) {
        Solution132267 sol = new Solution132267();
        int ans = 0;
//        ans = sol.solution(2, 1, 20);
        ans = sol.solution(3, 2, 20);
//        ans = sol.solution(3, 1, 20);
        System.out.println(ans);
    }
}