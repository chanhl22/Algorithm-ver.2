import java.util.Scanner;

public class B17427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		long res = 0;
		for (int i = 1; i <= input; i++) {
			res += (input / i) * i; 
		}
		System.out.println(res);
	}
}