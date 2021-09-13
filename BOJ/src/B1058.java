import java.util.Scanner;

public class B1058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        final int INF = 1000000;
        int[][] d = new int[n + 1][n + 1]; //현재까지 계산된 최소 비용
        for (int i = 1; i <= n; i++) {
            char[] str = sc.next().toCharArray();
            for (int j = 1; j <= n; j++) {
                d[i][j] = str[j - 1] == 'Y' ? 1 : INF;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                    //d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        int max = 0;
        //유명한 사람이 누군지 모르니 1번 사람부터 n번 사람까지 각각 2-친구를 구해줌
        //2-친구는 차이가 1이거나 2인 사람
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (d[i][j] <= 2) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}