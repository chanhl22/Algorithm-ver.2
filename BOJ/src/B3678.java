import java.util.Scanner;

public class B3678 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {-1, -1, 0, 1, 1, 0};
        int[] dy = {1, 0, -1, -1, 0, 1};
        int[] r = {0, 1, 0, 0, 0, 0}; //사용한 숫자
        int[][] a = new int[501][501]; //501로 한 이유는 딱히 없음, 201로 하면 범위를 넘어가길래..
        int[][] b = new int[501][501];
        int x = 250;
        int y = 250;
        a[x][y] = 1;
        b[x][y] = 1;
        int cur = 2;
        for (int level = 1; level <= 100; level++) { //이거도 대충 100보단 작겠지 싶어서..
            x += dx[5];
            y += dy[5];
            a[x][y] = cur++;
            boolean[] check1 = new boolean[6];
            for (int j = 0; j < 6; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                for (int l = 1; l <= 5; l++) {
                    if (b[nx][ny] == l) {
                        check1[l] = true;
                    }
                }
            }
            int min1 = -1;
            int temp1 = 0;
            for (int j = 1; j < 6; j++) {
                if (min1 == -1 || min1 > r[j]) {
                    if (check1[j] == false) {
                        min1 = r[j];
                        temp1 = j;
                    }
                }
            }
            b[x][y] = temp1;
            r[temp1]++;
            for (int k = 0; k < 6; k++) {
                int loop = level;
                if (k == 0) loop -= 1;
                for (int i = 0; i < loop; i++) {
                    x += dx[k];
                    y += dy[k];
                    a[x][y] = cur++;
                    boolean[] check2 = new boolean[6];
                    for (int j = 0; j < 6; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        for (int l = 1; l <= 5; l++) {
                            if (b[nx][ny] == l) {
                                check2[l] = true;
                            }
                        }
                    }
                    int min2 = -1;
                    int temp2 = 0;
                    for (int j = 1; j < 6; j++) {
                        if (min2 == -1 || min2 > r[j]) {
                            if (check2[j] == false) {
                                min2 = r[j];
                                temp2 = j;
                            }
                        }
                    }
                    b[x][y] = temp2;
                    r[temp2]++;
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < 501; i++) {
                for (int j = 0; j < 501; j++) {
                    if (a[i][j] == n) {
                        System.out.println(b[i][j]);
                    }
                }
            }
        }
    }
}
