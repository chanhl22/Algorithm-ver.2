package question;

import java.util.Arrays;

class Solution80 {
    public int[] solution(String[] replies, int n, int k) {
        int len = replies.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
//            answer[i] = check(replies[i], n, k);
        }

        return answer;
    }

//    private int check(String str, int n, int k) {
//        boolean ok = false;
//        int len = str.length();
//        for (int i = 0; i < len; i++) {
//            String temp1 = "";
//            for (int j = i; j < len / 2; j++) {
//                String temp2 = str.substring(i + 1);
//                temp1 += str.charAt(j);
//                if (temp1.length() >= n) {
//                    temp2.contains(temp1);
//                }
//            }
//        }
//    }
}


public class Tmax3 {
    public static void main(String[] args) {
        Solution80 sol = new Solution80();
        int ans[] = sol.solution(new String[]{"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"}, 3, 3);
        System.out.println(Arrays.toString(ans));
    }
}