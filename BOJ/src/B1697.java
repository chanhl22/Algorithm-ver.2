import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {
	static final int MAX = 200000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] check = new boolean[MAX];
		int[] dist = new int[MAX];
		check[n] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while(!q.isEmpty()) {
			int now = q.remove();
			if (now + 1 < MAX) {
				if(check[now+1] == false && dist[now+1] == 0) {
					check[now+1] = true;
					dist[now+1] = dist[now] + 1;
					q.add(now+1);
				}				
			}
			if (now - 1 >= 0) {
				if(check[now-1] == false && dist[now-1] == 0) {
					check[now-1] = true;
					dist[now-1] = dist[now] + 1;
					q.add(now-1);
				}				
			}
			if (now * 2 < MAX) {
				if(check[now*2] == false && dist[now*2] == 0) {
					check[now*2] = true;
					dist[now*2] = dist[now] + 1;
					q.add(now*2);
				}				
			}
		}
		System.out.println(dist[k]);
	}
}
