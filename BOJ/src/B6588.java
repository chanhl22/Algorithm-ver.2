import java.util.Scanner;

public class B6588 {
	static final int n = 1000000; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] check = new boolean [n+1];
		int[] prime = new int[n];
		check[0] = check[1] = true;
		int p = 0;
		for (int i = 2; i*i <= n ; i++) {
			if (check[i] == false) {
				prime[p++] = i;
				for (int j = i+i; j <= n; j+=i) {
					check[j] = true;
				}
			}
		}
		while (true) {
			int input = sc.nextInt();
			if(input == 0)
				break;
			for (int i = 1; i < prime.length; i++) {
				int value = prime[i];
				if (check[input - value]==false) {
					System.out.println(input + " = " + value + " + " + (input-value));
					break;
				}
			}
		}
	}
}