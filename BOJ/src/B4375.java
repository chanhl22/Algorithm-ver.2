import java.util.Scanner;

public class B4375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int input = sc.nextInt();
			int num = 0;
			for (int i = 0;; i++) {
				num = num*10+1;
				num %= input;
				if (num == 0) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}