import java.util.ArrayList;
import java.util.Scanner;

public class B16198 {
	static int n;
	
	static int go(ArrayList<Integer> a) {
		if (a.size() == 2) {
			return 0;
		}
		int ans = 0;
		for (int i = 1; i < a.size()-1; i++) {
			int sum = a.get(i-1) * a.get(i+1);
			ArrayList<Integer> b = new ArrayList<>(a);
			b.remove(i);
			sum += go (b);
			if (ans < sum) {
				ans = sum;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
	
		System.out.println(go(a));
	}

}
