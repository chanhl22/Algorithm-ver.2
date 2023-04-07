package question.PGWinterIntern;

class SolutionWinterIntern1 {
    public String solution(String str) {
        boolean flag = false; // *을 출력한 적이 있는가?

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i));
                flag = false;
            } else {
                if (!flag) {
                    sb.append("*");
                    flag = true;
                }
            }
        }

        return sb.toString();
    }
}

public class WinterIntern1 {
    public static void main(String[] args) {
        SolutionWinterIntern1 sol = new SolutionWinterIntern1();
//        String ans = sol.solution("aaabbcabb"); //a*b*cab*
        String ans = sol.solution("aaa"); //a*
//        String ans = sol.solution("abba"); //ab*a
        System.out.println(ans);
    }
}