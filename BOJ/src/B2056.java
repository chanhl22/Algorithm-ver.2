import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 1]; //작업하는데 걸린 시간
        int[] ind = new int[n + 1]; //in-degree
        ArrayList<Integer>[] a = new ArrayList[n + 1]; //연결 리스트
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            int c = sc.nextInt(); //선행 관계 작업 개수
            a[i] = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                int job = sc.nextInt(); //선행 관계 작업 번호
                a[job].add(i);
                ind[i] += 1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] d = new int[n + 1]; //걸린 시간을 계속 더해나갈 배열
        for (int i = 1; i <= n; i++) {
            if (ind[i] == 0) {
                q.add(i);
                d[i] = t[i];
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                ind[y] -= 1;
                if (d[y] < d[x] + t[y]) {
                    d[y] = d[x] + t[y];
                }
                if (ind[y] == 0) {
                    q.add(y);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
    }
}
