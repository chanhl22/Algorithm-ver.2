//playtime : 02:46:32

import java.util.*;

public class B1516 {
    static int n;
    static ArrayList<Integer>[] lists;
    static int[] value;
    static int[] inDegree;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lists = new ArrayList[n + 1];
        value = new int[n + 1];
        inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList();
        }
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            value[i] = num;
            while (true) {
                int temp = sc.nextInt();
                if (temp == -1) {
                    break;
                }
                lists[temp].add(i);
                inDegree[i]++;
            }
        }
        topologySort();
    }

    private static void topologySort() {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = value[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : lists[now]) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now] + value[next]);
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}