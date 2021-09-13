import java.util.Scanner;

public class B1748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		long res = 0;
		for (int start = 1, len = 1 ; start <= input; start *= 10, len++) {
			int end = start * 10 - 1;
			if(end > input) {
				end = input;
			}
			res += (long) len * (end - start + 1);
		}
		System.out.println(res);
	}

}
