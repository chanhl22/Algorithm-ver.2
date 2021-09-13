import java.util.Scanner;

public class B11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int last_line = len / 10;
        int finish = len % 10;
        for (int i = 0; i <= last_line; i++) {
            String ans = "";
            if (i == last_line) {
                for (int j = 0; j < finish; j++) {
                    ans += s.charAt(10*i+j);
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    ans += s.charAt(10*i+j);
                }
            }
            System.out.println(ans);
        }
    }
}

//Another Solution
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next();
//		sc.close();
//
//		for (int i = 0; i < input.length(); ++i) {
//			System.out.print(input.charAt(i));
//			if (i % 10 == 9) {
//				System.out.println();
//			}
//		}
//	}
//}