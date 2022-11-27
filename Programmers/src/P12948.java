// 11:42

class Solution12948 {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();

        int len = phone_number.length();
        for (int i = len - 1; i > len - 5; i--) {
            answer.insert(0, phone_number.charAt(i));
        }
        for (int i = len - 5; i >= 0; i--) {
            answer.insert(0, "*");
        }

        return answer.toString();
    }
}

public class P12948 {
    public static void main(String[] args) {
        Solution12948 sol = new Solution12948();
//        String ans = sol.solution("01033334444");
        String ans = sol.solution("027778087");
        System.out.println(ans);
    }
}