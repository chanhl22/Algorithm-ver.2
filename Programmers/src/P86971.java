/**
 * playtime = 42m 27s
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P86971 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
        ans = sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        //ans = sol.solution(9, new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int n, int[][] wires) {
            int len = wires.length;
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                lists.add(new ArrayList<>());
            }

            for (int i = 0; i < len; i++) {
                lists.get(wires[i][0]).add(wires[i][1]);
                lists.get(wires[i][1]).add(wires[i][0]);
            }

            int answer = Integer.MAX_VALUE;

            for (int i = 0; i < len; i++) {
                int x = wires[i][0];
                int y = wires[i][1];
                int firstCount = bfs(lists, x, y, n);
                int secondCount = Math.abs(n - firstCount);
                if (Math.abs(firstCount - secondCount) < answer) {
                    answer = Math.abs(firstCount - secondCount);
                }
            }

            return answer;
        }

        private int bfs(ArrayList<ArrayList<Integer>> lists, int x, int y, int n) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x);

            boolean[] visited = new boolean[n + 1];
            visited[x] = true;

            int count = 1;

            while (!queue.isEmpty()) {
                Integer remove = queue.remove();
                ArrayList<Integer> list = lists.get(remove);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != y && !visited[list.get(i)]) {
                        queue.add(list.get(i));
                        visited[list.get(i)] = true;
                        count++;
                    }
                }
            }

            return count;
        }
    }
}

//import java.util.*;
//
//class Solution41 {
//    static int bfs(ArrayList<Integer>[] a, int n, int start) {
//        int res = 1;
//        Queue<Integer> q = new LinkedList<>();
//        boolean[] check = new boolean[n + 1];
//        q.add(start);
//        check[start] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            for (int nx : a[x]) {
//                if (check[nx] == false) {
//                    q.add(nx);
//                    check[nx] = true;
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//
//    public int solution(int n, int[][] wires) {
//        int answer = -1;
//        ArrayList<Integer>[] a = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++) {
//            a[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            int x = wires[i][0];
//            int y = wires[i][1];
//            a[x].add(y);
//            a[y].add(x);
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            int del_x = wires[i][0];
//            int del_y = wires[i][1];
//            a[del_x].remove(Integer.valueOf(del_y));
//            a[del_y].remove(Integer.valueOf(del_x));
//            int temp1 = bfs(a, n, del_x);
//            int temp2 = bfs(a, n, del_y);
//            int max = Math.max(temp1, temp2);
//            int min = Math.min(temp1, temp2);
//            if (answer == -1 || answer > max - min) {
//                answer = max - min;
//            }
//            a[del_x].add(del_y);
//            a[del_y].add(del_x);
//        }
//        return answer;
//    }
//}

/// /Refactoring
//import java.util.*;
//
//class Solution41 {
//    static int bfs(ArrayList<Integer>[] a, int start, boolean[] check) {
//        int res = 1;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(start);
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            for (int nx : a[x]) {
//                if (check[nx] == false) {
//                    q.add(nx);
//                    check[nx] = true;
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//
//    public int solution(int n, int[][] wires) {
//        int answer = -1;
//        ArrayList<Integer>[] a = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++) {
//            a[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            int x = wires[i][0];
//            int y = wires[i][1];
//            a[x].add(y);
//            a[y].add(x);
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            int del_x = wires[i][0];
//            int del_y = wires[i][1];
//            boolean[] check = new boolean[n + 1];
//            check[del_x] = true;
//            check[del_y] = true;
//            int temp1 = bfs(a, del_x, check);
//            int temp2 = bfs(a, del_y, check);
//            int max = Math.max(temp1, temp2);
//            int min = Math.min(temp1, temp2);
//            if (answer == -1 || answer > max - min) {
//                answer = max - min;
//            }
//        }
//        return answer;
//    }
//}
//
//public class P86971 {
//    public static void main(String[] args) {
//        Solution41 sol = new Solution41();
//        int ans = 0;
//        ans = sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
//        //ans = sol.solution(9, new int[][]{{1,2},{2,3},{3,4}});
//        System.out.println(ans);
//    }
//}