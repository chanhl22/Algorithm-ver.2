//playtime = 01:17:13

import java.util.*;

class Solution101 {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            if (getParent(costs[i][0]) != getParent(costs[i][1])) {
                answer += costs[i][2];
                unionParent(costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }

    private static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}


public class P42861 {
    public static void main(String[] args) {
        Solution101 sol = new Solution101();
        int ans = 0;
        ans = sol.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        System.out.println(ans);
    }
}