import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution20 {
    public String solution(String[] research, int n, int k) {
        String answer = "None";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < research.length; i++) {
            for (int j = 0; j < research[i].length(); j++) {
                set.add(research[i].charAt(j));
            }
        }
        ArrayList<Character> a = new ArrayList<>(set);
        Collections.sort(a);
        int[][] arr = new int[research.length][a.size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < research.length; j++) {
                for (int l = 0; l < research[j].length(); l++) {
                    if (a.get(i) == research[j].charAt(l)) {
                        arr[i][j]++;
                    }
                }
            }
        }
        int save = 0;
        for (int i = 0; i < arr.length; i++) { //각 행 (검색어)
            for (int j = 0; j < arr[i].length - 1; j++) { // day
                int ret = 0;
                for (int l = 0; l < n; l++) {
                    ret += arr[i][j];
                }
                if (arr[i][j] >= k && arr[i][j + 1] >= k && ret >= 2 * n * k) {
                    if (ret > save) {
                        answer = Character.toString(a.get(i));
                        save = ret;
                    }
                }
            }
        }
        return answer;
    }
}


public class KL2 {
    public static void main(String[] args) {
        Solution20 sol = new Solution20();
        //String ans = sol.solution(new String[]{"abaaaa", "aaa", "abaaaaaa", "fzfffffffa"}, 2, 2);
        //String ans = sol.solution(new String[]{"yxxy","xxyyy"}, 2,1);
        //String ans = sol.solution(new String[]{"yxxy","xxyyy","yz"}, 2,1);
        String ans = sol.solution(new String[]{"xy","xy"}, 2,1);
        System.out.println(ans);
    }
}