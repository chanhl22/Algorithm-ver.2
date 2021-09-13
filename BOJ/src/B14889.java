import java.util.ArrayList;
import java.util.Scanner;

public class B14889 {
	static int[][] s;
	static int n;
	static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
		if (index == n) {
			if (first.size() != n/2) return -1;
			if (second.size() != n/2) return -1;
			int t1 = 0;
			int t2 = 0;
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					if(i == j) continue;
					t1 += s[first.get(i)][first.get(j)];
					t2 += s[second.get(i)][second.get(j)]; 
				}
			}
			int diff = Math.abs(t1-t2);
			return diff;
		}
		if (first.size() > n/2)
			return -1;
		if (second.size() > n/2)
			return -1;
		int ans = -1;
		first.add(index);
		int t1 = go(index + 1, first, second);
		if(ans == -1 || t1 != -1 && ans > t1) {
			ans = t1;
		}
		first.remove(first.size()-1);	
		second.add(index);
		int t2 = go(index + 1, first, second);
		if(ans == -1 || t2 != -1 && ans > t2) {
			ans = t2;
		}
		second.remove(second.size()-1);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();		
		System.out.println(go(0, first, second));
	}
}

//import java.util.*;
//public class Main {
//    static int[][] s;
//    static int n;
//    static int go(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
//        if (index == n) {
//            if (first.size() != n/2) return -1;
//            if (second.size() != n/2) return -1;
//            int t1 = 0;
//            int t2 = 0;
//            for (int i=0; i<n/2; i++) {
//                for (int j=0; j<n/2; j++) {
//                    if (i == j) continue;
//                    t1 += s[first.get(i)][first.get(j)];
//                    t2 += s[second.get(i)][second.get(j)];
//                }
//            }
//            int diff = Math.abs(t1-t2);
//            return diff;
//        }
//        int ans = -1;
//        first.add(index);
//        int t1 = go(index+1, first, second);
//        if (ans == -1 || (t1 != -1 && ans > t1)) {
//            ans = t1;
//        }
//        first.remove(first.size()-1);
//        second.add(index);
//        int t2 = go(index+1, first, second);
//        if (ans == -1 || (t2 != -1 && ans > t2)) {
//            ans = t2;
//        }
//        second.remove(second.size()-1);
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        s = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                s[i][j] = sc.nextInt();
//            }
//        }
//        ArrayList<Integer> first = new ArrayList<>();
//        ArrayList<Integer> second = new ArrayList<>();
//        System.out.println(go(0, first, second));
//    }
//}

//Solution by permutation
//import java.util.*;
//public class Main {
//	static boolean next_permutation(int[] a) {
//		int i = a.length-1;
//		while (i > 0 && a[i-1] >= a[i]) {
//			i -= 1;
//		}
//
//		if (i <= 0) {
//			return false;
//		}
//
//		int j = a.length-1;
//		while (a[j] <= a[i-1]) {
//			j -= 1;
//		}
//
//		int temp = a[i-1];
//		a[i-1] = a[j];
//		a[j] = temp;
//
//		j = a.length-1;
//		while (i < j) {
//			temp = a[i];
//			a[i] = a[j];
//			a[j] = temp;
//			i += 1;
//			j -= 1;
//		}
//		return true;
//	}
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[][] a = new int[n][n];
//		for (int i=0; i<n; i++) {
//			for (int j=0; j<n; j++) {
//				a[i][j] = sc.nextInt();
//			}
//		}
//		int[] b = new int[n];
//		for (int i=0; i<n/2; i++) {
//			b[i] = 1;
//		}
//		Arrays.sort(b);
//		int ans = 2147483647;
//		do {
//			ArrayList<Integer> first = new ArrayList<>();
//			ArrayList<Integer> second = new ArrayList<>();
//			for (int i=0; i<n; i++) {
//				if (b[i] == 0) {
//					first.add(i);
//				} else {
//					second.add(i);
//				}
//			}
//			int one = 0;
//			int two = 0;
//			for (int i=0; i<n/2; i++) {
//				for (int j=0; j<n/2; j++) {
//					if (i == j) continue;
//					one += a[first.get(i)][first.get(j)];
//					two += a[second.get(i)][second.get(j)];
//				}
//			}
//			int diff = one-two;
//			if (diff < 0) diff = -diff;
//			if (ans > diff) ans = diff;
//		} while(next_permutation(b));
//		System.out.println(ans);
//	}
//}


//Bitmask1
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] s = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                s[i][j] = sc.nextInt();
//            }
//        }
//        int ans = -1;
//        for (int i=0; i<(1<<n); i++) {
//            ArrayList<Integer> first = new ArrayList<>();
//            ArrayList<Integer> second = new ArrayList<>();
//            for (int j=0; j<n; j++) {
//                if ((i&(1<<j)) == 0) {
//                    first.add(j);
//                } else {
//                    second.add(j);
//                }
//            }
//            if (first.size() != n/2) continue;
//            int t1 = 0;
//            int t2 = 0;
//            for (int l1=0; l1<n/2; l1++) {
//                for (int l2=0; l2<n/2; l2++) {
//                    if (l1 == l2) continue;
//                    t1 += s[first.get(l1)][first.get(l2)];
//                    t2 += s[second.get(l1)][second.get(l2)];
//                }
//            }
//            int diff = Math.abs(t1-t2);
//            if (ans == -1 || ans > diff) {
//                ans = diff;
//            }
//        }
//        System.out.println(ans);
//    }
//}


//Bitmask2
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] s = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                s[i][j] = sc.nextInt();
//            }
//        }
//        int ans = -1;
//        for (int i=0; i<(1<<n); i++) {
//            int cnt = 0;
//            for (int j=0; j<n; j++) {
//                if ((i&(1<<j)) == 0) {
//                    cnt += 1;
//                }
//            }
//            if (cnt != n/2) continue;
//            ArrayList<Integer> first = new ArrayList<>();
//            ArrayList<Integer> second = new ArrayList<>();
//            for (int j=0; j<n; j++) {
//                if ((i&(1<<j)) == 0) {
//                    first.add(j);
//                } else {
//                    second.add(j);
//                }
//            }
//            int t1 = 0;
//            int t2 = 0;
//            for (int l1=0; l1<n/2; l1++) {
//                for (int l2=0; l2<n/2; l2++) {
//                    if (l1 == l2) continue;
//                    t1 += s[first.get(l1)][first.get(l2)];
//                    t2 += s[second.get(l1)][second.get(l2)];
//                }
//            }
//            int diff = Math.abs(t1-t2);
//            if (ans == -1 || ans > diff) {
//                ans = diff;
//            }
//        }
//        System.out.println(ans);
//    }
//}