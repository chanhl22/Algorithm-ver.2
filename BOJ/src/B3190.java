import java.util.ArrayList;
import java.util.Scanner;

public class B3190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            a[x][y] = 4; //사과를 놓음

        }
        int l = sc.nextInt();
        int[] x = new int[l];
        String[] c = new String[l];
        for (int i = 0; i < l; i++) {
            x[i] = sc.nextInt();
            c[i] = sc.next();
        }
        int head_x = 0;
        int head_y = 0;
        ArrayList<Integer> snake = new ArrayList<>();
        snake.add(0);
        snake.add(0);
        int dir = 0;
        int time = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (true) {
            //시간 증가
            time++;
            //방향에 따른 이동
            int nx = head_x + dx[dir];
            int ny = head_y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || a[nx][ny] == 1) {
                break;
            } else if (a[nx][ny] == 4) {
                head_x += dx[dir];
                head_y += dy[dir];
                a[head_x][head_y] = 1;
                snake.add(head_x);
                snake.add(head_y);
            } else {
                head_x += dx[dir];
                head_y += dy[dir];
                a[head_x][head_y] = 1;
                snake.add(head_x);
                snake.add(head_y);
                int del_x = snake.remove(0);
                int del_y = snake.remove(0);
                a[del_x][del_y] = 0;
            }
            //방향 전환
            for (int i = 0; i < l; i++) {
                if (time == x[i]) {
                    if (c[i].equals("D")) {
                        dir = (dir + 1) % 4;
                    } else if (c[i].equals("L")) {
                        dir = (dir + 3) % 4;
                    }
                }
            }
        }
        System.out.println(time);
    }
}
