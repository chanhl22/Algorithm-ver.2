class Solution5 {
    public long solution(String expression) {
        long answer = 0;
        String[] numbers = expression.split("\\+|-|\\*");
        String[] cal = expression.split("[0-9]");
        for (String s : cal) {
            System.out.println(s);
        }
        return answer;
    }
}


public class K67257 {
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        long ans = sol.solution("100-200*300-500+20");
        System.out.println(ans);
    }
}
