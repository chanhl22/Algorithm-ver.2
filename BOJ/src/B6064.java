import java.util.Scanner;

public class B6064 {
	public static void main(String[] args) throws NumberFormatException{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int num = 0;
		num = Integer.parseInt(input);
		while (num-- > 0) {
			String[] s = sc.nextLine().split(" ");
			
			int M = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]) - 1;
			int y = Integer.parseInt(s[3]) - 1;
			
			boolean check = false;
			for (int i = x; i < (M*N) ; i += M) {
				if (i%N == y) {
					System.out.println(i+1);
					check = true;
					break;
				}
			}
			if(!check) {
				System.out.println(-1);				
			}
			
		}
	}
}
