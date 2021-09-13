import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt(); //total floor
        int s = sc.nextInt(); //start
        int g = sc.nextInt(); //dest
        int u = sc.nextInt(); //up
        int d = sc.nextInt(); //down

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[f + 1];
        boolean[] check = new boolean[f + 1];
        q.add(s);
        check[s] = true;
        dist[s] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            if (x == g) {
                System.out.println(dist[g]);
                System.exit(0);
            }
            if (x + u >= 1 && x + u <= f && check[x + u] == false) {
                check[x + u] = true;
                dist[x + u] = dist[x] + 1;
                q.add(x + u);
            }
            if (x - d >= 1 && x - d <= f && check[x - d] == false) {
                check[x - d] = true;
                dist[x - d] = dist[x] + 1;
                q.add(x - d);
            }
        }
        System.out.println("use the stairs");
    }
}
