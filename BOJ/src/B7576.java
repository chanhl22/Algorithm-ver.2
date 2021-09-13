import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair2{
	int x;
	int y;
	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B7576 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static void bfs(int[][] a, int[][] dist, int n, int m, Queue<Pair2> q) {
		while(!q.isEmpty()) {
			Pair2 p = q.remove();
			int px = p.x;
			int py = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(a[nx][ny] == 0 && dist[nx][ny] == 0) {
						dist[nx][ny] = dist[px][py] + 1;
						q.add(new Pair2(nx,ny));
					}					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		Queue<Pair2> q = new LinkedList<Pair2>();
		
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					dist[i][j] = 1;
					q.add(new Pair2(i,j));
				}else {
					dist[i][j] = 0;					
				}
			}
		}

		bfs(a, dist, n, m, q);					


		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ans < dist[i][j] && a[i][j] != -1) {
					ans = dist[i][j];
				}
			}
		}
		for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && dist[i][j] == 0) {
                    ans = 0;
                }
            }
        }
		
		System.out.println(ans - 1);
	}
}
