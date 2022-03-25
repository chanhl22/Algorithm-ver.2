package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution108 {

    static ArrayList<Integer>[] list;
    static int[][] dist;
    static HashSet<Integer> set;

    public int[] solution(int n, int k, int[][] roads) {
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[n][n];

        init(roads);
        set = new HashSet<>();
        go(0, 0, k);
        ArrayList<Integer> result = new ArrayList<>(set);
        if (result.size() == 0) {
            return new int[]{-1};
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private void go(int index, int sum, int k) {
        if (sum > k) {
            return;
        }
        if (sum == k) {
            set.add(index);
            return;
        }
        for (int next : list[index]) {
            go (next, sum + dist[index][next], k);
        }
    }

    private void init(int[][] roads) {
        int n = roads.length;
        for (int i = 0; i < n; i++) {
            list[roads[i][0]].add(roads[i][1]);
            list[roads[i][1]].add(roads[i][0]);
            dist[roads[i][1]][roads[i][0]] = roads[i][2];
            dist[roads[i][0]][roads[i][1]] = roads[i][2];
        }
    }
}


public class SO_22_1 {
    public static void main(String[] args) {
        Solution108 sol = new Solution108();
//        int[] ans = sol.solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}});
//        int[] ans = sol.solution(4, 10, new int[][]{{0, 1, 2}, {0, 2, 3}});
        int[] ans = sol.solution(4, 11, new int[][]{{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}});
        System.out.println(Arrays.toString(ans));
    }
}