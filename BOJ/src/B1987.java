import java.util.Scanner;

public class B1987 {
    static int n;
    static int m;
    static char[][] arr;
    static boolean[] alpha;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;

    static void dfs(int x, int y, int cnt) {
        if (alpha[arr[x][y]-'A'] == true) {
            if (ans < cnt) {
                ans = cnt;
            }
            return;
        }
        alpha[arr[x][y]-'A'] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                dfs(nx, ny, cnt + 1);
            }
        }
        alpha[arr[x][y]-'A'] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        alpha = new boolean[26];
        dfs(0, 0, 0);
        System.out.println(ans);
    }
}
