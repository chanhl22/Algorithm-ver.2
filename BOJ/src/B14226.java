import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14226 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int[][] d = new int[s + 1][s + 1];
		for (int i = 0; i <= s; i++) {
			for (int j = 0; j <= s; j++) {
				d[i][j] = -1;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(0);
		d[1][0] = 0;
		while (!q.isEmpty()) {
			int x = q.remove();
			int y = q.remove();
			if (d[x][x] == -1) {
				d[x][x] = d[x][y] + 1;
				q.add(x);
				q.add(x);
			}
			if (x + y <= s && d[x + y][y] == -1) {
				d[x + y][y] = d[x][y] + 1;
				q.add(x + y);
				q.add(y);
			}
			if ( x - 1 >= 0 && d[x - 1][y] == -1) {
				d[x - 1][y] = d[x][y] + 1;
				q.add(x - 1);
				q.add(y);
			}

		}
		int ans = Integer.MAX_VALUE;
		for (int j = 1; j <= s; j++) {
			if (ans > d[s][j] && d[s][j] != -1) {
				ans = d[s][j];
			}
		}
		System.out.println(ans);
	}
}