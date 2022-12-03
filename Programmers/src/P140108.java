class Solution140108 {
    public int solution(String s) {
        int answer = 0;
        int curCnt = 0;
        int nextCnt = 0;
        int curChar = s.charAt(0);
        boolean cut = false;

        for (int i = 0; i < s.length(); i++) {
            if (cut) {
                curChar = s.charAt(i);
                cut = false;
            }

            if (s.charAt(i) == curChar) {
                curCnt++;
            } else {
                if (nextCnt > 0) {
                    nextCnt = 0;
                }
                nextCnt++;
                curChar = s.charAt(i);
                int temp = curCnt;
                curCnt = nextCnt;
                nextCnt = temp;
            }

            if (curCnt == nextCnt) {
                answer++;
                curCnt = 0;
                nextCnt = 0;
                cut = true;
            }
        }

        if (curCnt != 0 || nextCnt != 0) {
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
//        ans = sol.solution("baaa"); //2
//        ans = sol.solution("baccaaccaa"); //3
//        ans = sol.solution("ccaa"); //1
//        ans = sol.solution("ccaaa"); //2
//        ans = sol.solution("a"); //1
//        ans = sol.solution("aaaaaaaaacb"); //1
//        ans = sol.solution("aacb"); //1
//        ans = sol.solution("abaabc"); //2
//        ans = sol.solution("aaabbabb"); //2
//        ans = sol.solution("aaabbc"); //1
        System.out.println(ans);
    }
}