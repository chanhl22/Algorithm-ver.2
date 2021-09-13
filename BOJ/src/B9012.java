import java.util.Scanner;

public class B9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    cnt++;
                } else if (s.charAt(j) == ')') {
                    cnt--;
                }
                if (cnt < 0) {
                    break;
                }
            }
            if (cnt == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

//Another Solution by Stack
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int T = in.nextInt();
//		for(int i = 0; i < T; i++) {
//			System.out.println(solve(in.next()));
//		}
//	}
//
//	public static String solve(String s) {
//		Stack<Character> stack = new Stack<>();
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if (c == '(') {
//				stack.push(c);
//			}
//			else if (stack.empty()) {
//				return "NO";
//			}
//			else {
//				stack.pop();
//			}
//		}
//		if (stack.empty()) {
//			return "YES";
//		}
//		else {
//			return "NO";
//		}
//	}
//}