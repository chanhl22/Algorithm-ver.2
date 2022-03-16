//playtime = 01:00:47

import java.util.*;

class Solution105 {
    static final int START_VALUE = -30000;

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        int n = routes.length;
        int endPoint = START_VALUE;
        int index = 0;
        int count = 0;
        while (index < n) {
            if (endPoint < routes[index][0]) {
                endPoint = routes[index][0];
            } else {
                endPoint = routes[index][1];
                count++;
                index++;
                while (index < n && endPoint >= routes[index][0]) {
                    if (endPoint >= routes[index][1]) {
                        endPoint = routes[index][1];
                    }
                    index++;
                }
            }
        }
        return count;
    }
}

//Another Solution
//import java.util.Arrays;
//import java.util.Comparator;
//
//class Solution {
//    public int solution(int[][] routes) {
//        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
//        int ans = 0;
//        int last_camera = Integer.MIN_VALUE;
//        for (int[] a : routes) {
//            if (last_camera < a[0]) {
//                ++ans;
//                last_camera = a[1];
//            }
//        }
//        return ans;
//    }
//}

public class P42884 {
    public static void main(String[] args) {
        Solution105 sol = new Solution105();
        int ans = 0;
//        ans = sol.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
//        ans = sol.solution(new int[][]{{0, 5}, {6, 15}, {2, 7}, {15, 17}});
//        ans = sol.solution(new int[][]{{-20, 0}, {-10, -5}, {-9, -5}, {-7, -4}});
        ans = sol.solution(new int[][]{{-20, 0}, {-10, -5}, {-9, -5}, {-4, 10}});
//        ans = sol.solution(new int[][]{{-20, -10}, {-18, -15}, {-12, 5}, {0, 10}});
        System.out.println(ans);
    }
}