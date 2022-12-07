//playtime = 01:54:02

class Solution140108 {
    public int solution(String s) {
        int answer = 0;
        Character fixedChar = null;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (fixedChar == null) {
                fixedChar = s.charAt(i);
            }

            if (fixedChar == s.charAt(i)) {
                cnt1++;
            } else {
                cnt2++;
            }

            if (cnt2 == cnt1) {
                answer++;
                cnt2 = 0;
                cnt1 = 0;
                fixedChar = null;
            }
        }

        if (fixedChar != null) {
            answer++;
        }

        return answer;
    }
}

public class P140108 {
    public static void main(String[] args) {
        Solution140108 sol = new Solution140108();
        int ans = 0;
//        ans = sol.solution("banana"); //3
//        ans = sol.solution("abracadabra"); //6
//        ans = sol.solution("aaabbaccccabba"); //3
        System.out.println(ans);
    }
}