//playtime = 38:28
//답은 나오는데 메모리 초과과
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11400 {
    static int v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }
        int cnt = 0;
        boolean[][] check = new boolean[v + 1][v + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v + 1; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                int cut_x = i;
                int cut_y = list[i].get(j);
                if (!bfs(list, cut_x, cut_y)) {
                    if (check[cut_x][cut_y] == false) {
                        cnt++;
                        sb.append(cut_x + " " + cut_y + "\n");
                        check[cut_x][cut_y] = true;
                        check[cut_y][cut_x] = true;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    private static boolean bfs(ArrayList<Integer>[] list, int cx, int cy) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[v + 1];
        visited[1] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int next : list[x]) {
                if (visited[next] == false) {
                    if (x == cx && next == cy) continue;
                    if (x == cy && next == cx) continue;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        for (int i = 1; i < v + 1; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}