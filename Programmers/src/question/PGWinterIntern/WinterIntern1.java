package question.PGWinterIntern;

class SolutionWinterIntern1 {
    public String solution(String str) {
        char firstChar = str.charAt(0);

        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (firstChar == str.charAt(i)) {
                count++;
            } else {
                firstChar = str.charAt(i);
                if (count > 1) {
                    sb.append("*");
                }
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        if (count > 1) {
            sb.append("*");
        }
        return sb.toString();
    }
}

public class WinterIntern1 {
    public static void main(String[] args) {
        SolutionWinterIntern1 sol = new SolutionWinterIntern1();
//        String ans = sol.solution("aaabbcabb");
        String ans = sol.solution("abba");
        System.out.println(ans);
    }
}