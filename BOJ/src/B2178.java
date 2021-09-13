import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class B2178 {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static void bfs(int[][] a, int[][] dist, int x, int y, int cnt, int n , int m) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y));
		dist[0][0] = 1;
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int px = p.x;
			int py = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = px + dx[k];
				int ny = py + dy[k];
				if (nx < n && nx >= 0 && ny < m && ny >= 0) {
					if (dist[nx][ny] == -1 && a[nx][ny] == 1) {
						q.add(new Pair(nx,ny));
						dist[nx][ny] = dist[px][py] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = s.charAt(j) - '0';
			}	
		}
		int cnt = 0;
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = -1;
			}
		}
		bfs(a, dist, 0, 0, cnt, n, m);
		System.out.println(dist[n-1][m-1]);
	}
}
