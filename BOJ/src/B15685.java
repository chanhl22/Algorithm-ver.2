import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B15685 {

	static ArrayList<Integer> curve(int x, int y, int dir, int gen){
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(dir);
		for (int i = 0; i < gen; i++) {
			ArrayList<Integer> temp = new ArrayList<>(ans);
			Collections.reverse(temp);
			for (int j = 0; j < temp.size(); j++) {
				temp.set(j, (temp.get(j) + 1) % 4);
			}
			ans.addAll(temp);			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] c = new boolean[101][101];
		int[] dx = {0,-1,0,1};
		int[] dy = {1,0,-1,0};
		while (n-- > 0) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int dir = sc.nextInt();
			int gen = sc.nextInt();
			
			ArrayList<Integer> dirs = curve(x,y,dir,gen);
			c[x][y] = true;
			for (int i = 0; i < dirs.size(); i++) {
				x += dx[dirs.get(i)];
				y += dy[dirs.get(i)];
				c[x][y] = true;
			}
			
//			for (int d : dirs){
//				x += dx[d];
//				y += dy[d];
//				c[x][y] = true;
//			} 
			
		}
		int ans = 0;
		for (int i=0; i<=99; i++) {
			for (int j=0; j<=99; j++) {
				if (c[i][j] && c[i][j+1] && c[i+1][j] && c[i+1][j+1]) {
					ans += 1;
				}
			}
		}
		System.out.println(ans);

	}

}
