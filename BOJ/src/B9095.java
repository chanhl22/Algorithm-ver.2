/**
 * playtime = 13:36
 * 풀이횟수 = 4
 */

import java.util.Scanner;

public class B9095 {

	private static int[] list;

	public static void main(String[] args) {
		input();
		solution();
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
	}

	private static void solution() {
		for (int i : list) {
			System.out.println(recursive(0, i));
		}
	}

	private static int recursive(int sum, int goal) {
		if (sum == goal) {
			return 1;
		}

		if (sum > goal) {
			return 0;
		}

		int result = 0;
		for (int i = 1; i <= 3; i++) {
			result += recursive(sum + i, goal);
		}

		return result;
	}
}

//import java.util.*;
//
//public class B9095 {
//	static int is_count(int sum, int input) {
//		if (sum > input)
//			return 0;
//		if (sum == input)
//			return 1;
//		int count = 0;
//		for (int i = 1; i <= 3; i++) {
//			count += is_count(sum+i, input);
//		}
//		return count;
//			
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int ans = 0;
//		for (int i = 0; i < n; i++) {
//			int input = sc.nextInt();
//			ans = is_count(0, input);
//			System.out.println(ans);
//		}
//	}
//}

//import java.util.Scanner;
//
//public class B9095 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[] d = new int [11];
//		int s = sc.nextInt();
//
//		d[0] = 1;
//		d[1] = 1;
//		d[2] = 2;
//
//		for (int i = 0; i < s; i++) {
//			int n = sc.nextInt();
//			for (int j = 3; j <= n; j++) {
//				d[j] = d[j-1] + d[j-2] + d[j-3];
//			}
//
//			System.out.println(d[n]);
//
//		}
//	}
//}

//import java.util.*;
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int ans = 0;
//            for (int l1=1; l1<=3; l1++) {
//                if (l1 == n) {
//                    ans += 1;
//                }
//                for (int l2=1; l2<=3; l2++) {
//                    if (l1+l2 == n) {
//                        ans += 1;
//                    }
//                    for (int l3=1; l3<=3; l3++) {
//                        if (l1+l2+l3 == n) {
//                            ans += 1;
//                        }
//                        for (int l4=1; l4<=3; l4++) {
//                            if (l1+l2+l3+l4 == n) {
//                                ans += 1;
//                            }
//                            for (int l5=1; l5<=3; l5++) {
//                                if (l1+l2+l3+l4+l5 == n) {
//                                    ans += 1;
//                                }
//                                for (int l6=1; l6<=3; l6++) {
//                                    if (l1+l2+l3+l4+l5+l6 == n) {
//                                        ans += 1;
//                                    }
//                                    for (int l7=1; l7<=3; l7++) {
//                                        if (l1+l2+l3+l4+l5+l6+l7 == n) {
//                                            ans += 1;
//                                        }
//                                        for (int l8=1; l8<=3; l8++) {
//                                            if (l1+l2+l3+l4+l5+l6+l7+l8 == n) {
//                                                ans += 1;
//                                            }
//                                            for (int l9=1; l9<=3; l9++) {
//                                                if (l1+l2+l3+l4+l5+l6+l7+l8+l9 == n) {
//                                                    ans += 1;
//                                                }
//                                                for (int l0=1; l0<=3; l0++) {
//                                                    if (l1+l2+l3+l4+l5+l6+l7+l8+l9+l0 == n) {
//                                                        ans += 1;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            System.out.println(ans);
//        }
//    }
//}

//import java.util.*;
//
//public class Main {
//    public static int go(int sum, int goal) {
//        if (sum > goal) {
//            return 0;
//        }
//        if (sum == goal) {
//            return 1;
//        }
//        int now = 0;
//        for (int i=1; i<=3; i++) {
//            now += go(sum+i, goal);
//        }
//        return now;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            System.out.println(go(0, n));
//        }
//    }
//}