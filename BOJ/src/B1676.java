//playtime = 13:55

import java.util.Scanner;

public class B1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp % 5 == 0 && temp != 0) {
                cnt++;
                temp = temp / 5;
            }
        }
        System.out.println(cnt);
    }
}

//Best Solution
//import java.util.Scanner;
//
//public class B1676 {
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//
//		int num = in.nextInt();
//		int count = 0;
//
//		while (num >= 5) {
//			count += num / 5;
//			num /= 5;
//		}
//		System.out.println(count);
//	}
//}