import java.util.Scanner;

public class B14499 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int[] dice = new int[7];
		while (k-- > 0) {
			int order = sc.nextInt();
			order -= 1;
			int nx = x+dx[order];
			int ny = y+dy[order];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (order == 0) { //right
				int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
			}
			if (order == 1) { //left
				int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
			}
			if (order == 2) { //up
				int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
			}
			if (order == 3) { //down
				int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
			}
			x = nx;
			y = ny;
			if (a[x][y] == 0) {
				a[x][y] = dice[6];
			}
			else {
				dice[6] = a[x][y];
				a[x][y] = 0;
			}
			System.out.println(dice[1]);
		}

	}

}
