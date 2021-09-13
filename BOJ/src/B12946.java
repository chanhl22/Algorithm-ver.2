import java.util.Arrays;
import java.util.Scanner;

public class B12946 {
	static int n;
	static char[][] a;
	static int ans = 0;
	static int[][] color;
	static int[] dx = { -1, -1, 0, 0, 1, 1 };
	static int[] dy = { 0, 1, -1, 1, -1, 0 };

	static void bfs(int x, int y, int c) {
		color[x][y] = c;
		ans = Math.max(ans, 1);
		for (int k = 0; k < 6; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (a[nx][ny] == 'X') {
					if (color[nx][ny] == -1) {
						bfs(nx, ny, 1 - c);
					}
					ans = Math.max(ans, 2);
					if (color[nx][ny] == c) {
						ans = Math.max(ans, 3);
					}

				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new char[n][n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.next().toCharArray();
		}
		color = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(color[i], -1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'X' && color[i][j] == -1) {
					bfs(i, j, 0);
				}
			}
		}
		System.out.println(ans);
	}
}
