import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        int b = Integer.parseInt(numbers[2]);
        int[][] base = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                base[i][j] = Integer.parseInt(array[j]);
                if (min > base[i][j]) {
                    min = base[i][j];
                }
                if (max < base[i][j]) {
                    max = base[i][j];
                }
            }
        }
        int ans = -1;
        int ans_h = 0;
        for (int h = min; h <= max; h++) {
            int[][] a =new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = base[i][j];
                }
            }
            int have = b;
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] < h) { //현재 높이가 지정한 높이보다 낮다면 현재 높이를 증가시켜야함
                        time += h - a[i][j];
                        have -= h - a[i][j];
                        a[i][j] += h - a[i][j];
                    } else if (a[i][j] > h) { //현재 높이가 지정한 높이보다 높다면 현재 높이를 감소시켜야함
                        time += 2 * (a[i][j] - h);
                        have += a[i][j] - h;
                        a[i][j] -= a[i][j] - h;
                    }
                }
            }
            if (have < 0) {
                continue;
            }
            if (ans == -1 || ans > time) {
                ans = time;
                ans_h = h;
            } else if (ans == time) {
                if (ans_h < h) {
                    ans_h = h;
                }
            }
        }
        System.out.println(ans + " " + ans_h);
    }
}
