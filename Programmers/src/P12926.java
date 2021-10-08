class Solution44 {
    public String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            char temp = (char)(s.charAt(i) + n);
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && temp > 'z') {
                temp = (char)(temp - 26);
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' && temp > 'Z') {
                temp = (char)(temp - 26);
            }
            answer += Character.toString(temp);
        }
        return answer;
    }
}


public class P12926 {
    public static void main(String[] args) {
        Solution44 sol = new Solution44();
        String ans = sol.solution("AB", 1);
        //String ans = sol.solution("z", 1);
        //String ans = sol.solution("a B z", 4);
        System.out.println(ans);
    }
}