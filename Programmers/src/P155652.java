/**
 * playtime = 01:56:26
 */

class Solution155652 {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        int[] sArray = new int[s.length()];
        int[] skipArray = new int[skip.length()];

        for (int i = 0; i < s.length(); i++) {
            sArray[i] = s.charAt(i) - 'a';
        }

        for (int i = 0; i < skip.length(); i++) {
            skipArray[i] = skip.charAt(i) - 'a';
        }

        for (int i = 0; (i < sArray.length); i++) {
            for (int j = 0; j < index; j++) {
                do {
                    sArray[i]++;
                    if (sArray[i] == 26) {
                        sArray[i] = 0;
                    }
                } while (findContains(sArray, skipArray));
            }
            answer.append((char) (sArray[i] + 97));
        }
        return answer.toString();
    }

    private boolean findContains(int[] sArray, int[] skipArray) {
        for (int s : sArray) {
            for (int skip : skipArray) {
                if (s == skip) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class P155652 {
    public static void main(String[] args) {
        Solution155652 sol = new Solution155652();
        String ans = sol.solution("aukks", "wbqd", 5);
//        String ans = sol.solution("ybcde", "az", 1); //bcdef
//        String ans = sol.solution("z", "abcdefghij", 20); //n
        System.out.println(ans);
    }
}