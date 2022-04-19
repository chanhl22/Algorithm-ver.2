package question;

import java.util.ArrayList;

class Solution125 {
    static ArrayList<Long> list = new ArrayList<>();

    public long solution(long n) {
        long answer = 0;
        long len = 0;
        int i = 1;
        while (true) {
            if ((long) Math.pow(2, i) - i - 1 >= n) {
                len = i;
                break;
            }
            i++;
        }
        for (int j = 0; j < len; j++) {
           list.add((long) Math.pow(3, j));
        }


        return answer;
    }

}


public class OpenSurvey_22_3 {
    public static void main(String[] args) {
        Solution125 sol = new Solution125();
        long ans = 0;
//        ans = sol.solution(4);
        ans = sol.solution(11);
        System.out.println(ans);
    }
}