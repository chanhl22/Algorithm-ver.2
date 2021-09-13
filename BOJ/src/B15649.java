import java.util.Scanner;

public class B15649 {
	static boolean[] c = new boolean[9];
	static int[] a = new int[9];
	
	static void go(int index, int n, int m) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return ;
		}
		for (int i = 1; i <= n; i++) {
			if (c[i]) 
				continue;
			c[i] = true;
			a[index] = i;
			go(index + 1, n, m);
			c[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		go(0, n, m);
	}

}
