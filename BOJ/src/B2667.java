import java.util.Arrays;
import java.util.Scanner;

public class B2667 {
	
	static int[] dx = {0, 0 ,-1, 1};
	static int[] dy = {-1, 1 ,0, 0};
	
	static void dfs(int i, int j, int[][] d, int[][] a, int cnt, int n) {
		d[i][j] = cnt;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx < n && nx >= 0 && ny < n && ny >= 0) {
				if (a[nx][ny] == 1 && d[nx][ny] == 0) {
					dfs(nx, ny, d, a, cnt, n);					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();			
			for (int j = 0; j < n; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		int d[][] = new int[n][n];
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(d[i][j] == 0 && a[i][j] == 1) {
					dfs(i, j, d, a, cnt, n);
					cnt++;
				}
			}
		}
		cnt--;
		int[] ans = new int[cnt];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(d[i][j] != 0) {
					ans[d[i][j] - 1] += 1;
				}
			}
		}
		System.out.println(cnt);
		Arrays.sort(ans);
		for (int i = 0; i < cnt; i++) {
			System.out.println(ans[i]);			
		}
	}

}

//import java.util.*;
//
//class Pair {
//    int x;
//    int y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Main {
//    public static final int[] dx = {0, 0, 1, -1};
//    public static final int[] dy = {1, -1, 0, 0};
//    public static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
//        Queue<Pair> q = new LinkedList<Pair>();
//        q.add(new Pair(x, y));
//        group[x][y] = cnt;
//        while (!q.isEmpty()) {
//            Pair p = q.remove();
//            x = p.x;
//            y = p.y;
//            for (int k=0; k<4; k++) {
//                int nx = x+dx[k];
//                int ny = y+dy[k];
//                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
//                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
//                        q.add(new Pair(nx, ny));
//                        group[nx][ny] = cnt;
//                    }
//                }
//            }
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[][] a = new int[n][n];
//        for (int i=0; i<n; i++) {
//            String s = sc.nextLine();
//            for (int j=0; j<n; j++) {
//                a[i][j] = s.charAt(j) - '0';
//            }
//        }
//        int cnt = 0;
//        int[][] group = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                if (a[i][j] == 1 && group[i][j] == 0) {
//                    bfs(a, group, i, j, ++cnt, n);
//                }
//            }
//        }
//        int[] ans = new int[cnt];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                if (group[i][j] != 0) {
//                    ans[group[i][j]-1]+=1;
//                }
//            }
//        }
//        Arrays.sort(ans);
//        System.out.println(cnt);
//        for (int i=0; i<cnt; i++) {
//            System.out.println(ans[i]);
//        }
//    }
//}