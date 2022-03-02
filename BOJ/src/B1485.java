//playtime = 52:48

import java.util.Arrays;
import java.util.Scanner;

public class B1485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[][] point = new int[4][2];
            for (int i = 0; i < 4; i++) {
                point[i][0] = sc.nextInt();
                point[i][1] = sc.nextInt();
            }
            int ans = 0;
            int[] dist = new int[6];
            int k = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    dist[k] = (int) Math.pow(point[i][0] - point[j][0], 2) + (int) Math.pow(point[i][1] - point[j][1], 2);
                    k++;
                }
            }
            Arrays.sort(dist);
            if (dist[0] == dist[1] && dist[1] == dist[2] && dist[2] == dist[3] && dist[4] == dist[5]) {
                ans = 1;
            }
            System.out.println(ans);
        }
    }
}
