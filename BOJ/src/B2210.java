import java.util.HashSet;
import java.util.Scanner;

public class B2210 {
    static HashSet<Integer> ans;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] a;

    static void go(int x, int y, int index, int num) {
        if (index == 5) {
            ans.add(num);
            return ;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                go(nx, ny, index + 1, num * 10 + a[nx][ny]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = new HashSet<>();
        a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                go(i, j, 0, a[i][j]);
            }
        }
        System.out.println(ans.size());
    }
}

//시작 인덱스를 1로 해서 6으로 끝내는게 가독성이 더 좋음