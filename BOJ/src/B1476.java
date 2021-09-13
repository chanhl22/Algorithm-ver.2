//import java.util.*;
//
//public class B1476 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int E = sc.nextInt();
//		int S = sc.nextInt();
//		int M = sc.nextInt();
//		int e=1,s=1,m=1;
//		for (int i = 1;; i++) {
//			if(e == E && s == S && m == M) {
//				System.out.println(i);
//				break;
//			}
//			e++;
//			s++;
//			m++;
//			if(e == 16) {
//				e = 1;
//			}
//			if(s == 29) {
//				s = 1;
//			}
//			if (m == 20) {
//				m = 1;
//			}
//		}
//	}
//}

import java.util.Scanner;

public class B1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		E--;
		S--;
		M--;
		
		for (int i = 0;; i++) {
			if(i%15 == E && i%28 == S && i%19 == M) {
				System.out.println(i+1);
				break;
			}
		}
	}
}

//import java.util.*;
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int E = sc.nextInt();
//        int S = sc.nextInt();
//        int M = sc.nextInt();
//        int e=1,s=1,m=1;
//        for (int i=1;; i++) {
//            if (e == E && s == S && m == M) {
//                System.out.println(i);
//                break;
//            }
//            e += 1;
//            s += 1;
//            m += 1;
//            if (e == 16) {
//                e = 1;
//            }
//            if (s == 29) {
//                s = 1;
//            }
//            if (m == 20) {
//                m = 1;
//            }
//        }
//    }
//}