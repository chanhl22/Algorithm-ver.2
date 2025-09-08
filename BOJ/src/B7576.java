/**
 * playtime = 38m 55s
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair7576 {
	int x;
	int y;
	Pair7576(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B7576 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	static void bfs(int[][] a, int[][] dist, int n, int m, Queue<Pair7576> q) {
		while(!q.isEmpty()) {
			Pair7576 p = q.remove();
			int px = p.x;
			int py = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(a[nx][ny] == 0 && dist[nx][ny] == 0) {
						dist[nx][ny] = dist[px][py] + 1;
						q.add(new Pair7576(nx,ny));
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
		Queue<Pair7576> q = new LinkedList<Pair7576>();

		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					dist[i][j] = 1;
					q.add(new Pair7576(i,j));
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

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.StringTokenizer;
//
//public class B7576 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int M = Integer.parseInt(st.nextToken()); // 열 (가로)
//        int N = Integer.parseInt(st.nextToken()); // 행 (세로)
//
//        int[][] a = new int[N][M];
//        Deque<int[]> q = new ArrayDeque<>(); // {r, c, day}
//
//        for (int r = 0; r < N; r++) {
//            st = new StringTokenizer(br.readLine());
//            for (int c = 0; c < M; c++) {
//                a[r][c] = Integer.parseInt(st.nextToken());
//                if (a[r][c] == 1) {
//                    q.add(new int[]{r, c, 0}); // 익은 토마토: 출발점, day = 0
//                }
//            }
//        }
//
//        int[] dr = {-1, 1, 0, 0};
//        int[] dc = {0, 0, -1, 1};
//        int maxDay = 0;
//
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            int r = cur[0], c = cur[1], day = cur[2];
//            // 현재까지 최대 소요일 갱신
//            if (day > maxDay) maxDay = day;
//
//            for (int k = 0; k < 4; k++) {
//                int nr = r + dr[k];
//                int nc = c + dc[k];
//                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
//                if (a[nr][nc] != 0) continue; // 0(익지 않음)만 익힐 수 있음
//                a[nr][nc] = 1; // 익혔다고 표시
//                q.add(new int[]{nr, nc, day + 1});
//            }
//        }
//
//        // BFS 후에 아직 0이 있으면 불가능
//        for (int r = 0; r < N; r++) {
//            for (int c = 0; c < M; c++) {
//                if (a[r][c] == 0) {
//                    System.out.println(-1);
//                    return;
//                }
//            }
//        }
//        System.out.println(maxDay);
//    }
//}
