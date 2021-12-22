class Solution69 {
    public int solution(String[] scores) {
        int answer = 0;
        int n = scores.length;
        for (int k = 0; k < n; k++) {
            String str = scores[k];
            //F 2개 이상?
            int f_count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'F') {
                    f_count++;
                }
            }
            if (f_count >= 2) {
                continue;
            }

            //A 2개 이상?
            int a_count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'A') {
                    a_count++;
                }
            }
            if (a_count >= 2) {
                answer++;
                continue;
            }

            //나머지 조건
            int max = -1;
            int min = -1;
            int ret = 0;
            for (int i = 0; i < str.length(); i++) {
                int temp = 0;
                if (str.charAt(i) == 'A') {
                    temp = 5;
                } else if (str.charAt(i) == 'B') {
                    temp = 4;
                } else if (str.charAt(i) == 'C') {
                    temp = 3;
                } else if (str.charAt(i) == 'D') {
                    temp = 2;
                } else if (str.charAt(i) == 'E') {
                    temp = 1;
                } else if (str.charAt(i) == 'F') {
                    temp = 0;
                }
                if (max < temp) {
                    max = temp;
                }
                if (min == -1 || min > temp) {
                    min = temp;
                }
                ret += temp;
            }
            ret = ret - max - min;
            ret = ret / (str.length() - 2);
            if (ret >= 3) {
                answer++;
            }
        }
        return answer;
    }
}


public class Esoft1 {
    public static void main(String[] args) {
        Solution69 sol = new Solution69();
        int ans = 0;
//        ans = sol.solution(new String[]{"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"});
//        ans = sol.solution(new String[]{"BCD","ABB","FEE"});
//        ans = sol.solution(new String[]{"FFF","FFF","FFF"});
//        ans = sol.solution(new String[]{"AAFF","AAFF","AAFF"});
//        ans = sol.solution(new String[]{"CCCCDF","CCCCDF","CCCCDF"});
        ans = sol.solution(new String[]{"CCCCDE","CCCCDE","CCCCDE"});

        System.out.println(ans);
    }
}