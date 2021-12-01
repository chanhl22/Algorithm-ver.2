//playtime = 21:26

import java.util.Scanner;

public class B10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int index = sc.nextInt();
            int ans_x = 0;
            int ans_y = 0;
            boolean ok = false;
            for (int j = 0; j < m; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    index--;
                    if (index == 0) {
                        ans_x = i;
                        ans_y = j;
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            if (ans_y + 1 < 10) {
                System.out.println((n - ans_x) + "" + 0 + "" + (ans_y + 1));
            } else {
                System.out.println((n - ans_x) + "" + (ans_y + 1));
            }
        }
    }
}

//Best Solution
//reference : https://st-lab.tistory.com/77
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//
//		Scanner in = new Scanner(System.in);
//
//		int T = in.nextInt();	// 테스트 케이스
//
//
//		for(int i = 0; i < T; i++) {
//
//			int H = in.nextInt();
//			int W = in.nextInt(); 	// 쓸모없는 변수다.
//			int N = in.nextInt();
//
//			if(N % H == 0) {
//				System.out.println((H * 100) + (N / H));
//
//			} else {
//				System.out.println(((N % H) * 100) + ((N / H) + 1));
//			}
//		}
//	}
//}
