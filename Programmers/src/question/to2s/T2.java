package question.to2s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution11 {
    public int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer;
        int n = requests.length;
        int cnt = 0;
        if (sticky) {
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer>[] lists = new ArrayList[servers];
            for (int i = 0; i < servers; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                if (map.containsKey(requests[i])) {
                    lists[map.get(requests[i])].add(requests[i]);
                } else {
                    map.put(requests[i], cnt);
                    lists[cnt].add(requests[i]);
                    cnt = ++cnt % servers;
                }
            }
            answer = new int[servers][];
            for (int i = 0; i < servers; i++) {
                answer[i] = new int[lists[i].size()];
            }
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[i].length; j++) {
                    answer[i][j] = lists[i].get(j);
                }
            }
            return answer;
        } else {
            answer = new int[servers][servers];
            for (int j = 0; j < servers; j++) {
                for (int i = 0; i < servers; i++) {
                    answer[i][j] = requests[cnt++];
                }
            }
            return answer;
        }
    }
}


public class T2 {
    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        int[][] ans = {};
        //ans = sol.solution(2,false,new int[]{1,2,3,4});
        //ans = sol.solution(2, true, new int[]{1, 1, 2, 2});
        ans = sol.solution(2, true, new int[]{1, 2, 2, 3, 4, 1});
        System.out.println(Arrays.deepToString(ans));
    }
}