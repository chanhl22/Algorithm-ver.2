//playtime = 01:37:30

import java.util.*;

class Solution97 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int m = report.length;
        int[] answer = new int[n];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(report[i]);
        }
        HashMap<String, Integer> check_rep = new HashMap<>(); //신고 당한 횟수
        HashMap<String, Integer> count_rep = new HashMap<>(); //메일 발송
        for (int i = 0; i < n; i++) {
            check_rep.put(id_list[i], 0);
            count_rep.put(id_list[i], 0);
        }
        ArrayList<String> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).split(" ");
            if (check_rep.containsKey(temp[1])) {
                check_rep.put(temp[1], check_rep.get(temp[1]) + 1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).split(" ");
            if (check_rep.get(temp[1]) >= k) {
                count_rep.put(temp[0], count_rep.get(temp[0]) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            answer[i] = count_rep.get(id_list[i]);
        }
        return answer;
    }
}

public class P92334 {
    public static void main(String[] args) {
        Solution97 sol = new Solution97();
//        int[] ans = sol.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        int[] ans = sol.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        System.out.println(Arrays.toString(ans));
    }
}