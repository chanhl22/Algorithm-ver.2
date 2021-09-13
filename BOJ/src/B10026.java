import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B10026 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;

    static boolean can(boolean blind, char from, char to){
        if (from == to) return true;
        if(blind) {
            if(from == 'R' && to == 'G') return true;
            if(from == 'G' && to == 'R') return true;
        }
        return false;
    }

    static int bfs(char[][] a, boolean blind) {
        int ans = 0;
        boolean[][] check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == false) {
                    ans += 1;
                    check[i][j] = true;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    while (!q.isEmpty()) {
                        int x = q.remove();
                        int y = q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if(check[nx][ny] == true) continue;
                                //can true : same block
                                //can false : diff block
                                if(can(blind,a[x][y],a[nx][ny])){
                                    check[nx][ny] = true;
                                    q.add(nx);
                                    q.add(ny);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[][] a = new char[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        System.out.println(bfs(a, false) + " " + bfs(a, true));
    }
}