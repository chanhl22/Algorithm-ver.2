//playtime = 18:20

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution107 {
    static ArrayList<Integer>[] list;

    public int solution(int n, int[][] edge) {
        input(n, edge);
        return bfs(n);
    }

    private int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : list[now]) {
                if (visited[next] == -1) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] > max) {
                max = visited[i];
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == max) {
                count++;
            }
        }
        return count;
    }

    private void input(int n, int[][] edge) {
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            list[x].add(y);
            list[y].add(x);
        }
    }
}

public class P49189 {
    public static void main(String[] args) {
        Solution107 sol = new Solution107();
        int ans = 0;
        ans = sol.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(ans);
    }
}