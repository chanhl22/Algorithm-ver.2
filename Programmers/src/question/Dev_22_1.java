package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution120 {
    static int n;
    static int minPoint;
    static int maxPoint;
    static ArrayList<Integer> list;


    public int[][] solution(int[][] dist) {
        n = dist.length;
        minPoint = 0;
        maxPoint = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < dist[i][j]) {
                    max = dist[i][j];
                    minPoint = i;
                    maxPoint = j;
                }
            }
        }
        list = new ArrayList<>();
        bfs(dist);
        int[][] answer = new int[2][list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[0][i] = list.get(i);
            answer[1][i] = list.get(list.size() - 1 - i);
        }
        Arrays.sort(answer, (o1, o2) -> o1[0] - o2[0]);
        return answer;
    }

    private void bfs(int[][] dist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(minPoint);
        boolean[] visited = new boolean[n];
        visited[minPoint] = true;
        visited[maxPoint] = true;
        list.add(minPoint);
        while (!q.isEmpty()) {
            int now = q.remove();
            int min = -1;
            int tempPoint = -1;
            for (int i = 0; i < n; i++) {
                if (visited[i] == true) continue;
                if (min == -1 || dist[now][i] < min) {
                    min = dist[now][i];
                    tempPoint = i;
                }
            }
            if (tempPoint == -1) continue;
            q.add(tempPoint);
            visited[tempPoint] = true;
            list.add(tempPoint);
        }
        list.add(maxPoint);
    }
}


public class Dev_22_1 {
    public static void main(String[] args) {
        Solution120 sol = new Solution120();
        int[][] ans = sol.solution(new int[][]{{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}});
        System.out.println(Arrays.deepToString(ans));
    }
}