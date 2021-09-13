import java.util.Scanner;

public class B1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                a[s.charAt(i) - 'A'] += 1;
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                a[s.charAt(i) - 'a'] += 1;
            }
        }
        int ans = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (ans < a[i]) {
                ans = a[i];
                index = i;
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (a[i] == ans) {
                cnt++;
            }
        }
        if (cnt > 1) {
            System.out.println("?");
            System.exit(0);
        } else {
            System.out.println((char) ('A' + index));
        }
    }
}

//Code Refactoring
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int[] arr = new int[26];
//		String s = in.next();
//		for (int i = 0; i < s.length(); i++){
//			if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
//				arr[s.charAt(i) - 'A']++;
//			}
//			else {
//				arr[s.charAt(i) - 'a']++;
//			}
//		}
//		int max = -1;
//		char ch = '?';
//		for (int i = 0; i < 26; i++) {
//			if (arr[i] > max) {
//				max = arr[i];
//				ch = (char) (i + 65);
//			}
//			else if (arr[i] == max) {
//				ch = '?';
//			}
//		}
//		System.out.print(ch);
//	}
//}
