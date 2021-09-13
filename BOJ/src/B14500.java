import java.util.Scanner;

public class B14500 {
	static int[][] a;
	static int ans = Integer.MIN_VALUE;
	static int n;
	static int m;
	static boolean[][] check;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	
	static void go (int x, int y, int index, int sum) {
		if (index == 4) {
			if (ans < sum) {
				ans = sum;
			}
			return ;
		}
		if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (check[x][y]) return;
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			go(x+dx[i], y+dy[i], index+1, sum+a[x][y]);
		}
		check[x][y] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				go (i,j,0,0);
				if (j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2];
                    if (i-1 >= 0) {
                        int temp2 = temp + a[i-1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (i+1 < n) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                }
                if (i+2 < n) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j];
                    if (j+1 < m) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (j-1 >= 0) {
                        int temp2 = temp + a[i+1][j-1];
                        if (ans < temp2) ans = temp2;
                    }
                }
			}
		}
		System.out.println(ans);
	}
}

//import java.util.*;
//
//public class B14500 {
//	static int[][][] block = {
//		 {{0,1}, {0,2}, {0,3}},
//		 {{1,0}, {2,0}, {3,0}},
//		 {{1,0}, {1,1}, {1,2}},
//		 {{0,1}, {1,0}, {2,0}},
//		 {{0,1}, {0,2}, {1,2}},
//		 {{1,0}, {2,0}, {2,-1}},
//		 {{0,1}, {0,2}, {-1,2}},
//		 {{1,0}, {2,0}, {2,1}},
//		 {{0,1}, {0,2}, {1,0}},
//		 {{0,1}, {1,1}, {2,1}},
//		 {{0,1}, {1,0}, {1,1}},
//		 {{0,1}, {-1,1}, {-1,2}},
//		 {{1,0}, {1,1}, {2,1}},
//		 {{0,1}, {1,1}, {1,2}},
//		 {{1,0}, {1,-1}, {2,-1}},
//		 {{0,1}, {0,2}, {-1,1}},
//		 {{0,1}, {0,2}, {1,1}},
//		 {{1,0}, {2,0}, {1,1}},
//		 {{1,0}, {2,0}, {1,-1}},
//	};
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		int[][] a = new int[x][y];
//		for (int i = 0; i < x; i++) {
//			for (int j = 0; j < y; j++) {
//				a[i][j] = sc.nextInt();
//			}
//		}
//		int res = 0;
//		for (int i = 0; i < x; i++) {
//			for (int j = 0; j < y; j++) {
//				for (int k = 0; k < 19; k++) {
//					int sum = a[i][j];
//					for (int l = 0; l < 3; l++) {
//						int a = i + block[k][l][0];
//						int b = j + block[k][l][1];
//						if (a >= 0 && a < x && b >= 0 && b < y) {
//							sum += a[a][b];
//						}
//					}
//					if (res < sum) {
//						res = sum;
//					}
//				}
//			}
//		}
//		System.out.println(res);
//	}
//}