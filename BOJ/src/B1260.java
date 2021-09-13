//인접리스트
import java.util.*;

public class B1260 {

	static boolean check[];
	static ArrayList<Integer>[] a;

	public static void dfs(int x) {
		if(check[x])
			return ;
		check[x] = true;
		System.out.print(x + " ");
		for (int i = 0; i < a[x].size(); i++) {
			int y = a[x].get(i);
			if(check[y] == false)
				dfs(y);
		}
//		코드를 깔끔하게
//		for (int y : a[x]) {
//			if(check[y] == false)
//				dfs(y);
//		}
	}

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		check[x] = true;
		while(!q.isEmpty()) {
			int y = q.remove();
			System.out.print(y + " ");
			for (int i = 0; i < a[y].size(); i++) {
				int z = a[y].get(i);
				if(check[z] == false) {
					check[z] = true;
					q.add(z);
				}
			}
//			코드를 깔끔하게
//			for (int z : a[y]) {
//				if(check[z] == false){
//					check[z] = true;
//					q.add(z);
//				}
//
//			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		a = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			a[from].add(to);
			a[to].add(from);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(a[i]);
		}
		check = new boolean[n+1];
		dfs(start);
		System.out.println();
		check = new boolean[n+1];
		bfs(start);
		System.out.println();

	}

}

////인접행렬
//import java.util.*;
//
//public class B1260 {
//
//	static int n, m;
//	static boolean check[];
//	static boolean[][] a;
//
//	public static void dfs(int x) {
//		if(check[x])
//			return ;
//		check[x] = true;
//		System.out.print(x + " ");
//		for (int i = 1; i <= n; i++) {
//			if(a[x][i] == true && check[i] == false)
//				dfs(i);
//		}
//	}
//
//	public static void bfs(int x) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(x);
//		check[x] = true;
//		while(!q.isEmpty()) {
//			int y = q.remove();
//			System.out.print(y + " ");
//			for (int i = 1; i <= n; i++) {
//				if(a[y][i] == true && check[i] == false) {
//					check[i] = true;
//					q.add(i);
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
//		int start = sc.nextInt();
//		a = new boolean[n+1][n+1];
//		for (int i = 0; i < m; i++) {
//			int from = sc.nextInt();
//			int to = sc.nextInt();
//			a[from][to] = true;
//			a[to][from] = true;
//		}
//		check = new boolean[n+1];
//		dfs(start);
//		System.out.println();
//		check = new boolean[n+1];
//		bfs(start);
//		System.out.println();
//
//	}
//
//}

