//playtime = 01:13:16

import java.util.ArrayList;
import java.util.Arrays;

class Solution82 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int len = words.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0, j = 0; i < len; i++) {
            if (i % n == 0) {
                j = 0;
            } else {
                j++;
            }
            if (i == 0 && j == 0) {
                if(words[i].length() == 1) {
                    answer[0] = j + 1; //번호
                    answer[1] = i / n + 1; //차례
                    return answer;
                }
                list.add(words[i]);
                continue;
            }
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
                    || list.contains(words[i]) || words[i].length() == 1) {
                answer[0] = j + 1; //번호
                answer[1] = i / n + 1; //차례
                return answer;
            } else {
                list.add(words[i]);
            }
        }
        return answer;
    }
}


public class P12981 {
    public static void main(String[] args) {
        Solution82 sol = new Solution82();
//        int ans[] = sol.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
//        int ans[] = sol.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
//        int ans[] = sol.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
//        int ans[] = sol.solution(4, new String[]{"ab","bc","cd","de","ef","fe","ef"});
        int ans[] = sol.solution(4, new String[]{"aba","aba","cd","de","ef","fe","ef"});
        System.out.println(Arrays.toString(ans));
    }
}