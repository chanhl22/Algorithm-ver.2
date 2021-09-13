import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution24 {
    public int[] solution(String[] id_list, String[] report1, int k) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < report1.length; i++) {
            set.add(report1[i]);
        }
        String[] report = set.toArray(new String[0]);
        int n = id_list.length;
        int m = report.length;
        int[] answer = new int[n];
        String[] u = new String[m]; //신고한 유저
        String[] r = new String[m]; //신고받은 유저
        for (int i = 0; i < report.length; i++) {
            String[] arr = report[i].split(" ");
            u[i] = arr[0];
            r[i] = arr[1];
        }
        int[] cnt = new int[n]; //각 유저별로 신고당한 횟수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (id_list[i].equals(r[j])) {
                    cnt[i]++;
                }
            }
        }
        ArrayList<String> stop = new ArrayList<>(); //정지 당한 유저
        for (int i = 0; i < n; i++) {
            if (cnt[i] >= k) {
                stop.add(id_list[i]);
            }
        }
        for (int i = 0; i < m; i++) { //신고된 유저를 찾음
            for (int j = 0; j < stop.size(); j++) { //정지된 유저와 비교
                if (r[i].equals(stop.get(j))) {
                    for (int l = 0; l < n; l++) {
                        if (u[i].equals(id_list[l])) {
                            answer[l] += 1;
                        }
                    }
                }
            }
        }
        return answer;
    }
}


public class KK1 {
    public static void main(String[] args) {
        Solution24 sol = new Solution24();
        int[] ans = sol.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        //int[] ans = sol.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        System.out.println(Arrays.toString(ans));
    }
}
