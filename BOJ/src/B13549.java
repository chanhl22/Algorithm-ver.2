import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13549 {
	public static final int MAX = 200000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] d = new int[MAX];
		boolean[] check = new boolean[MAX];
		check[n] = true;
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> next_q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty()) {
			int p = q.remove();
			if (p*2 < MAX && check[p*2] == false) {
				d[p*2] = d[p];
				check[p*2] = true;
				q.add(p*2);
			}
			if (p+1 < MAX && check[p+1] == false) {
				d[p+1] = d[p] + 1;
				check[p+1] = true;
				next_q.add(p+1);
			}
			if (p-1 >= 0 && check[p-1] == false) {
				d[p-1] = d[p] + 1;
				check[p-1] = true;
				next_q.add(p-1);
			}
			if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<Integer>();
            }
		}
		System.out.println(d[k]);
	}
}

// Solution by Deque
//import java.util.*;
//
//public class B13549 {
//	public static final int MAX = 1000000;
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		boolean[] c = new boolean[MAX];
//		int[] d = new int[MAX];
//		c[n] = true;
//		d[n] = 0;
//		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
//		q.add(n);
//		while (!q.isEmpty()) {
//			int now = q.poll();
//			for (int next : new int[]{now*2, now-1, now+1}) {
//				if (next >= 0 && next < MAX) {
//					if (c[next] == false) {
//						c[next] = true;
//						if (next == now*2) {
//							q.addFirst(next);
//							d[next] = d[now];
//						} else {
//							q.addLast(next);
//							d[next] = d[now] + 1;
//						}
//					}
//				}
//			}
//		}
//		System.out.println(d[m]);
//	}
//}
