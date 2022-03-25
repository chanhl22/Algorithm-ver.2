package question;

import java.util.Arrays;

class Solution47 {
    public String[] solution(int startNumber, int endNumber) {
        if (startNumber < endNumber) {
            int n = endNumber - startNumber + 1;
            String[] answer = new String[n];
            String temp = "";
            for (int i = startNumber, j = 0; i <= endNumber; i++, j++) {
                temp += Integer.toString(i);
                answer[j] = String.format("%010d", Integer.parseInt(temp));
            }
            return answer;
        } else {
            int n = startNumber - endNumber + 1;
            String[] answer = new String[n];
            String temp = "";
            for (int i = startNumber, j = 0; i >= endNumber; i--, j++) {
                temp += Integer.toString(i);
                answer[j] = String.format("%010d", Integer.parseInt(temp));
            }
            return answer;
        }
    }
}


public class C1 {
    public static void main(String[] args) {
        Solution47 sol = new Solution47();
        //String[] ans = sol.solution(2,5);
        //String[] ans = sol.solution(9,1);
        String[] ans = sol.solution(5,3);
        System.out.println(Arrays.toString(ans));
    }
}
