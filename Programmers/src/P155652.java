/**
 * playtime = 13:14
 * 안풀림..
 */

class Solution155652 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        char firstChar = 'a';
        boolean check = false;
        for (char i = 'a'; i < 'z'; i++) {
            for (int j = 0; j < skip.length(); j++) {
                if (i == skip.charAt(j)) {
                    break;
                }
                check = true;
            }
            if (check) {
                firstChar = i;
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c += 1;
                if (c > 'z') {
                    c = firstChar;
                }
                for (int k = 0; k < skip.length(); k++) {
                    if (c == skip.charAt(k)) {
                        c += 1;
                        if (c > 'z') {
                            c = firstChar;
                        }
                    }
                }
            }
            answer.append(c);
        }
        return answer.toString();
    }
}

public class P155652 {
    public static void main(String[] args) {
        Solution155652 sol = new Solution155652();
//        String ans = sol.solution("aukks", "wbqd", 5);
//        String ans = sol.solution("ybcde", "az", 1); //bcdef
        String ans = sol.solution("z", "abcdefghij", 20); //n
        System.out.println(ans);
    }
}