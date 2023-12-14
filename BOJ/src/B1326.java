/**
 * playtime = 17m 44s
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1326 {

    private static int n;
    private static int[] steppingStone;
    private static int start;
    private static int end;

    public static void main(String[] args) {
        input();
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] visitedCount = new int[n + 1];
        Arrays.fill(visitedCount, -1);
        visitedCount[start] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int move = steppingStone[x];
            for (int i = x; i <= n; i += move) {
                if (visitedCount[i] == -1) {
                    visitedCount[i] = visitedCount[x] + 1;
                    q.add(i);
                }
            }
            for (int i = x; i > 0; i -= move) {
                if (visitedCount[i] == -1) {
                    visitedCount[i] = visitedCount[x] + 1;
                    q.add(i);
                }
            }
        }

        System.out.println(visitedCount[end]);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        steppingStone = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            steppingStone[i] = sc.nextInt();
        }
        start = sc.nextInt();
        end = sc.nextInt();
    }
}
