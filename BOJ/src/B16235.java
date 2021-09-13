import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B16235 {
	static final int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static final int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // size of land
		int m = sc.nextInt(); // size of land
		int k = sc.nextInt(); // a few years later
		int[][] a = new int[n][n]; // added nutrients
		int[][] d = new int[n][n]; // first nutrients
		ArrayList<Integer>[][] tree = new ArrayList[n][n]; // tree in each matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
				d[i][j] = 5;
				tree[i][j] = new ArrayList<>();
			}
		}

		while (m-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			tree[x - 1][y - 1].add(age);
		}

		// Season calculation each matrix
		while (k-- > 0) {
			int[][] p = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					Collections.sort(tree[i][j]);
					ArrayList<Integer> temp = new ArrayList<>();
					int dead = 0;
					for (int x : tree[i][j]) {
						if (x <= d[i][j]) {
							d[i][j] -= x;
							temp.add(x + 1);
							if ((x + 1) % 5 == 0) {
								for (int l = 0; l < 8; l++) {
									int nx = i + dx[l];
									int ny = j + dy[l];
									if (0 <= nx && nx < n && 0 <= ny && ny < n) {
										p[nx][ny] += 1;
									}
								}
							}
						} else {
							dead += x / 2;
						}
					}
					tree[i][j] = temp;
					d[i][j] += dead;
                    d[i][j] += a[i][j];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int l = 0; l < p[i][j]; l++) {
						tree[i][j].add(1);
					}
				}
			}
			
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += tree[i][j].size();
			}
		}
		System.out.println(ans);
	}
}
