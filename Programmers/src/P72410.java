class Solution43 {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        if (answer.equals("")) {
            answer = "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$", "");
        }
        if(answer.length() <= 2)
            while(answer.length() < 3)
                answer += answer.charAt(answer.length() - 1);
        return answer;
    }
}

public class P72410 {
    public static void main(String[] args) {
        Solution43 sol = new Solution43();
        String ans = sol.solution("z-+.^._");
        //System.out.println(ans);
    }
}
