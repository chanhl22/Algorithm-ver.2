import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair7562 {
	int x;
	int y;
	Pair7562(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B7562 {

	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int l = sc.nextInt();
			int[][] a = new int[l][l];
			Queue<Pair7562> q = new LinkedList<Pair7562>();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int res_x = sc.nextInt();
			int res_y = sc.nextInt();
			q.add(new Pair7562(x,y));
			int[][] dist = new int[l][l];
			dist[x][y] = 1;
			while (!q.isEmpty()) {
				Pair7562 p = q.remove();
				int px = p.x;
				int py = p.y;
				for (int i = 0; i < 8; i++) {
					int nx = px + dx[i];
					int ny = py + dy[i];
					if (nx < l && nx >= 0 && ny < l && ny >= 0) {
						if (dist[nx][ny] == 0) {
							dist[nx][ny] = dist[px][py] + 1;
							q.add(new Pair7562(nx,ny));
						}
					}
				}
			}
			System.out.println(dist[res_x][res_y] - 1);
		}
	}
}
