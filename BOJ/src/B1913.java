import java.util.Scanner;

public class B1913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int find = sc.nextInt();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[n][n];
        boolean[][] check = new boolean[n][n];
        int x = 0;
        int y = 0;
        int dir = 0;
        int num = n * n;
        while (true) {
            if (check[x][y] == true) {
                break;
            }
            check[x][y] = true;
            arr[x][y] = num;
            num--;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || check[nx][ny] == true) {
                dir = (dir + 1) % 4;
            }
            x = x + dx[dir];
            y = y + dy[dir];
        }
        int arr_x = -1;
        int arr_y = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == find) {
                    arr_x = i + 1;
                    arr_y = j + 1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(arr_x + " " + arr_y);
    }
}
