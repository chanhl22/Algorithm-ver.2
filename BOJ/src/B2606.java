import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computer = sc.nextInt();
        int connect = sc.nextInt();
        int[][] a = new int[computer][computer];
        for (int i = 0; i < connect; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            a[x][y] = a[y][x] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[computer];
        q.add(0);
        check[0] = true;
        int ans = 0;
        while(!q.isEmpty()) {
            int x = q.remove();
            for (int k = 0; k < computer; k++) {
                if (a[x][k] == 1 && check[k] == false) {
                    q.add(k);
                    check[k] = true;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
