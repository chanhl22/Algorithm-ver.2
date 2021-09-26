import java.util.Scanner;

public class B2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //W
        int m = sc.nextInt(); //M
        int k = sc.nextInt();
        int cnt = 0;
        while(n > 1 && m > 0) { //5 3 3
            n -= 2;
            m -= 1;
            cnt++;
        }
        if (n + m >= k) {
            System.out.println(cnt);
        } else {
            k -= n + m; //11 6 5
            int temp = 0;
            if (k % 3 == 0) {
                temp = k / 3;
            } else {
                temp = k / 3 + 1;
            }
            System.out.println(cnt - temp);
        }
    }
}

//Best Solution
//import java.util.Scanner;
//public class Main {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
//		int max =  n/2 < m? n/2 : m;
//		k -= n + m - max*3;
//		while(k > 0) {
//			k -= 3; max--;
//		}
//		System.out.print(max);
//	}
//}