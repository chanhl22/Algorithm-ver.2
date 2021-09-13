class Solution12 {
    public boolean solution(String amountText) {
        boolean answer = true;
        int cnt = 3;
        for (int i = amountText.length() - 1; i >= 0; i--) {
            if (0 <= amountText.charAt(i) - '0' && 9 >= amountText.charAt(i) - '0') {
                answer = true;
            } else if (amountText.charAt(i) == ',' && i == ((amountText.length() - 1) - cnt)) {
                cnt += 4;
                answer = true;
            } else {
                answer = false;
                break;
            }
        }
        return answer;
    }
}


public class T3 {
    public static void main(String[] args) {
        Solution12 sol = new Solution12();
        boolean ans = false;
        //ans = sol.solution("10000");
        //ans = sol.solution("25,000");
        //ans = sol.solution("250,00");
        //ans = sol.solution("10,000,");
        ans = sol.solution("39900");
        //ans = sol.solution(",999,000");
        //ans = sol.solution("1,000,000");
        //ans = sol.solution("1,000,000,000");
        //ans = sol.solution("21,000");
        System.out.println(ans);
    }
}