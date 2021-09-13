import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12851 {
    static final int MAX = 200000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] check = new boolean[MAX]; // 방문 여부 검사
        int[] dist = new int[MAX]; // 거리
        int[] cnt = new int[MAX]; // 방법의 개수

        //bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        dist[n] = 0;
        cnt[n] = 1;
        while (!q.isEmpty()) {
            int now = q.remove(); // 현재 위치
            for (int next : new int[]{now + 1, now - 1, now * 2}) {
                if (next >= 0 && next < MAX) {
                    if (check[next] == false) {
                        check[next] = true;
                        dist[next] = dist[now] + 1;
                        cnt[next] = cnt[now];
                        q.add(next);
                    } else if (dist[next] == dist[now] + 1) {
                        cnt[next] += cnt[now];
                    }
                }
            }
        }
        System.out.println(dist[k]);
        System.out.println(cnt[k]);
    }
}
