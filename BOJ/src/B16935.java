import java.util.Scanner;

public class B16935 {

	static int[][] op1(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] ans = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans[i][j] = a[n-i-1][j];				
			}
		}
		return ans;
	}
	
	static int[][] op2(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] ans = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {		
				ans[i][j] = a[i][m-j-1];
			}
		}
		return ans;
	}
	
	static int[][] op3(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] ans = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {		
				ans[i][j] = a[n-j-1][i];
			}
		}
		return ans;
	}
	
	static int[][] op4(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] ans = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {		
				ans[i][j] = a[j][m-i-1];
			}
		}
		return ans;
	}
	
	static int[][] op5(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] ans = new int[n][m];
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < m/2; j++) {		
				ans[i][j] = a[n/2 + i][j];
				ans[i][j + m/2] = a[i][j];
				ans[i + n/2][j + m/2] = a[i][j + m/2];
				ans[i + n/2][j] = a[n/2 + i][j + m/2];
			}
		}
		return ans;
	}
	
	static int[][] op6(int[][] a){
		int n = a.length;
		int m = a[0].length;
		int[][] ans = new int[n][m];
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < m/2; j++) {		
				ans[i][j] = a[i][j + m/2];
				ans[i][j + m/2] = a[n/2 + i][j + m/2];
				ans[i + n/2][j + m/2] = a[i + n/2][j];
				ans[i + n/2][j] = a[i][j];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		while (r-- > 0) {
			int calculate = sc.nextInt();
			if (calculate == 1) {
				a = op1(a);
			}
			else if (calculate == 2) {
				a = op2(a);
			}
			else if (calculate == 3) {
				a = op3(a);
			}
			else if (calculate == 4) {
				a = op4(a);
			}
			else if (calculate == 5) {
				a = op5(a);
			}
			else if (calculate == 6) {
				a = op6(a);
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
