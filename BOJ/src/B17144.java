import java.util.Scanner;

public class B17144 {
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int r;
	static int c;
	static int[][] a; 
	
	static void go(int sx, int sy, int z) {
		int x = sx;
		int y = sy + 1;
		int k = 0;
		int prev = 0;
		while (true) {
			if (x == sx && y == sy) break;
			int temp = a[x][y];
			a[x][y] = prev;
			prev = temp;			
			x += dx[k];
			y += dy[k];
			if (x < 0 || x >= r || y < 0 || y >= c) {
				x -= dx[k];
				y -= dy[k];
				k += z;
				k %= 4;
				x += dx[k];
				y += dy[k];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		int t = sc.nextInt();
		a = new int[r][c];
		int x = 0;
		int y = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = sc.nextInt();
				if (a[i][j] == -1) {
					x = i;
					y = j;
				}
			}
		}
		
		//�̼����� Ȯ��
		int[][] b = new int[r][c];
		while(t-- > 0) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (a[i][j] <= 0) continue;
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < r && ny >= 0 && ny < c && a[nx][ny] != -1) {
							cnt += 1;
						}
					}
					if (cnt > 0) {
						for (int k = 0; k < 4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if (nx >= 0 && nx < r && ny >= 0 && ny < c && a[nx][ny] != -1) {
								b[nx][ny] += a[i][j] / 5;
							}
						}
					}
					a[i][j] = a[i][j] - (cnt * (a[i][j] / 5)); 
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					a[i][j] += b[i][j];
					b[i][j] = 0;
				}
			}

			//����û���� �۵�
			go(x-1,y,1);
			go(x,y,3);
		}
		
		//����
		int ans = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] != -1) {
					ans += a[i][j];
				}
			}
		}
		System.out.println(ans);
	}
}
