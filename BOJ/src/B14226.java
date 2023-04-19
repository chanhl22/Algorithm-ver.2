/**
 * playtime = 41:07
 * 풀이횟수 = 2
 * [참고] 첫 풀이 처럼 각 조건에 대한 조건식을 간단하게 처리할 수 있음
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        int[][] record = new int[S + 1][S + 1];
        record[1][0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);

        while (!q.isEmpty()) {
            int screen = q.remove();
            int clipboard = q.remove();

            controlC(S, record, q, screen, clipboard);
            controlV(S, record, q, screen, clipboard);
            delete(S, record, q, screen, clipboard);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < record.length; i++) {
            if (record[S][i] != 0 && min > record[S][i]) {
                min = record[S][i];
            }
        }

        System.out.println(min);
    }

    private static void controlC(int S, int[][] record, Queue<Integer> q, int screen, int clipboard) {
        if (screen >= 0 && screen < S + 1 && screen < S + 1
                && record[screen][screen] == 0) {
            record[screen][screen] = record[screen][clipboard] + 1;
            q.add(screen);
            q.add(screen);
        }
    }

    private static void controlV(int S, int[][] record, Queue<Integer> q, int screen, int clipboard) {
        if (screen + clipboard >= 0 && screen + clipboard < S + 1 && clipboard >= 0 && clipboard < S + 1
                && record[screen + clipboard][clipboard] == 0) {
            record[screen + clipboard][clipboard] = record[screen][clipboard] + 1;
            q.add(screen + clipboard);
            q.add(clipboard);
        }
    }

    private static void delete(int S, int[][] record, Queue<Integer> q, int screen, int clipboard) {
        if (screen - 1 >= 0 && screen - 1 < S + 1 && clipboard >= 0 && clipboard < S + 1
                && record[screen - 1][clipboard] == 0) {
            record[screen - 1][clipboard] = record[screen][clipboard] + 1;
            q.add(screen - 1);
            q.add(clipboard);
        }
    }
}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class B14226 {
//	public static void main(String[] arg) {
//		Scanner sc = new Scanner(System.in);
//		int s = sc.nextInt();
//		int[][] d = new int[s + 1][s + 1];
//		for (int i = 0; i <= s; i++) {
//			for (int j = 0; j <= s; j++) {
//				d[i][j] = -1;
//			}
//		}
//		Queue<Integer> q = new LinkedList<>();
//		q.add(1);
//		q.add(0);
//		d[1][0] = 0;
//		while (!q.isEmpty()) {
//			int x = q.remove();
//			int y = q.remove();
//			if (d[x][x] == -1) {
//				d[x][x] = d[x][y] + 1;
//				q.add(x);
//				q.add(x);
//			}
//			if (x + y <= s && d[x + y][y] == -1) {
//				d[x + y][y] = d[x][y] + 1;
//				q.add(x + y);
//				q.add(y);
//			}
//			if ( x - 1 >= 0 && d[x - 1][y] == -1) {
//				d[x - 1][y] = d[x][y] + 1;
//				q.add(x - 1);
//				q.add(y);
//			}
//
//		}
//		int ans = Integer.MAX_VALUE;
//		for (int j = 1; j <= s; j++) {
//			if (ans > d[s][j] && d[s][j] != -1) {
//				ans = d[s][j];
//			}
//		}
//		System.out.println(ans);
//	}
//}