import java.util.ArrayList;
import java.util.Scanner;

public class B1707 {
	static int[] color;
	static ArrayList<Integer>[] a; 
	
	static boolean dfs(int start, int c) {
		color[start] = c;
		for(int x : a[start]) {
			if (color[x] == 0) {
				if(dfs(x, 3-c) == false) {
					return false;
				}
			}
			else if (color[x] == color[start])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			a = new ArrayList[v+1];
			for (int j = 1; j <= v; j++) {
				a[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j < e; j++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				a[from].add(to);
				a[to].add(from);
			}
			color = new int[v+1];
			boolean ok = true;
			for (int j = 1; j <= v; j++) {
				if (color[j] == 0) {
					if(dfs(j, 1) == false) {
						ok = false;
					}
				}
			}
			System.out.println(ok ? "YES" : "NO");			
		}
	}
}
