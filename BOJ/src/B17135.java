import java.util.Scanner;

public class B17135 {
    static int[][] a;
    static int n;
    static int m;
    static int d;

    static int cals(int l1, int l2, int l3) {
        //원본을 복사
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[i][j];
            }
        }
        int ans = 0;
        while (true) {
            //적의 숫자를 계산
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (b[i][j] == 1) {
                        cnt += 1;
                    }
                }
            }
            if (cnt == 0) break; // 적이 없어지면 끝
            //적의 좌표를 저장할 공간
            int[][] selected_enemy = new int[3][2];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    selected_enemy[i][j] = -1;
                }
            }
            //궁수와 적의 거리를 구해서 가장 가까운 적의 좌표를 뽑아냄
            int[] archer = {l1, l2, l3};
            for (int k = 0; k < 3; k++) {
                int rx = n;
                int ry = archer[k];
                int dist = -1;
                int x = -1;
                int y = -1;
                for (int j = 0; j < m; j++) {
                    for (int i = 0; i < n; i++) {
                        if (b[i][j] == 0) continue;
                        int dx = Math.abs(rx - i);
                        int dy = Math.abs(ry - j);
                        int dd = dx + dy;
                        if (dd <= d) {
                            if (dist == -1 || dist > dd) {
                                dist = dd;
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
                selected_enemy[k][0] = x;
                selected_enemy[k][1] = y;
            }
            //b좌표에서 삭제
            for (int k = 0; k < 3; k++) {
                int x = selected_enemy[k][0];
                int y = selected_enemy[k][1];
                if (x == -1) continue; //-1로 초기화 했는데 -1일 때가 나오면 안되서 제외
                if (b[x][y] == 1) {
                    ans += 1;
                }
                b[x][y] = 0;
            }
            //밑으로 옮김
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if (i == 0) {
                        b[i][j] = 0;
                    } else {
                        b[i][j] = b[i - 1][j];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        //3개의 궁수 위치를 찾음
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    int temp = cals(i, j, k); //궁수 위치에 대한 각각의 최대값 계산
                    if (ans < temp) {
                        ans = temp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
