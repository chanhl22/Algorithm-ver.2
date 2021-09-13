import java.util.Scanner;

public class B15662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[][] a = new int[n][8];
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		int k = sc.nextInt(); // turn

		while (k-- > 0) {
			int no = sc.nextInt() - 1;
			int dir = sc.nextInt();
			int[] d = new int[n];
			d[no] = dir;
			//left
			for (int i = no; i > 0; i--) {
				if(a[i-1][2] != a[i][6]) {
					d[i-1] = -d[i]; 
				}
				else {
					break;
				}
			}
			//right
			for (int i = no; i < n-1; i++) {
				if(a[i+1][6] != a[i][2]) {
					d[i+1] = -d[i]; 
				}
				else {
					break;
				}
			}
			for (int i = 0; i < n; i++) {
				if (d[i] == 0) {
					continue;
				}
				else if (d[i] == 1) {
					int temp = a[i][7];
					for (int j = 7; j > 0; j--) {
						a[i][j] = a[i][j-1];
					}
					a[i][0] = temp;
				}
				else if (d[i] == -1) {
					int temp = a[i][0];
					for (int j = 0; j < 7; j++) {
						a[i][j] = a[i][j+1];
					}
					a[i][7] = temp;
				}
			}
			
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (a[i][0] == 1) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}

}