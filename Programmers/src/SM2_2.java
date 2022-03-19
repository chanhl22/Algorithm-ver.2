import java.util.*;

public class SM2_2 {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int n;
    static int m;
    static int k;
    static int[] response;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        response = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int student = sc.nextInt();
            response[student] = sc.nextInt();
        }
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }

        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                bfs(i);
            }
        }
        int sum = 0;
        int temp = n;
        for (int i = 1; i <= n; i++) {
            if (response[i] == 0) {
                temp--;
            }
            sum += response[i];
        }
        double result = Math.ceil(((double) sum / temp) * 100) / 100;
        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        boolean[] check = new boolean[n + 1];
        check[start] = true;
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : list[now]) {
                if (visited[next] == false) {
                    q.add(next);
                    visited[next] = true;
                    check[next] = true;
                }
            }
        }
        int sum = 0;
        int res = 0; //응답한 사람 수
        for (int i = 1; i <= n; i++) {
            if (check[i] == true) {
                if (response[i] != 0) {
                    res++;
                    sum += response[i];
                }
            }
        }
        if (res != 0) {
            int avg = sum / res;
            for (int i = 1; i <=n ; i++) {
                if (check[i] == true) {
                    if (response[i] == 0) {
                        response[i] = avg;
                    }
                }
            }
        }
    }
}