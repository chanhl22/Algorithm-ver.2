import java.util.*;

class Solution2 {
    public String solution(String s) {
        char c = s.charAt(0);
        if (c >= 'A' && c <= 'Z') {  // please fix condition
            return "upper";
        } else if (c >= 'a' && c <= 'z') {  // please fix condition
            return "lower";
        } else if (c >= '0' && c <= '9') {  // please fix condition
            return "digit";
        } else {
            return "other";
        }
    }
}


public class C1011 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
//        String ans = sol.solution("10ch");
//        String ans = sol.solution("ch");
//        String ans = sol.solution("CH");
        String ans = sol.solution("~");
        System.out.println(ans);
    }
}
