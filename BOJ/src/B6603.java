import java.util.Scanner;

public class B6603 {
	static int n;
	static boolean[] c;
	static int[] a;
	
	static void go(int index, int start) {
		if (index == 6) {
			for (int i = 0; i < n; i++) {
				if (c[i]) {
					System.out.print(a[i] + " ");					
				}
			}
			System.out.println();
		}
		
		for (int i = start; i < n; i++) {
			c[i] = true;
			go(index+1, i+1);
			c[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true){
            n = sc.nextInt();
 
            if(n==0){
                break;
            }
            a = new int[n];
            c = new boolean[n];
            for (int i = 0; i <n ; i++) {
                a[i] = sc.nextInt();
            }
 
            go(0, 0);
            System.out.println();
		}
	}
}

//Another Solution
//import java.util.*;
//public class Main {
//    static ArrayList<Integer> lotto = new ArrayList<>();
//    static void solve(int[] a, int index, int cnt) {
//        if (cnt == 6) {
//            for (int num : lotto) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//            return;
//        }
//        int n = a.length;
//        if (n == index) return;
//        lotto.add(a[index]);
//        solve(a, index+1, cnt+1);
//        lotto.remove(lotto.size()-1);
//        solve(a, index+1, cnt);
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            int n = sc.nextInt();
//            if (n == 0) break;
//            int[] a = new int[n];
//            for (int i=0; i<n; i++) {
//                a[i] = sc.nextInt();
//            }
//            solve(a, 0, 0);
//            System.out.println();
//        }
//    }
//}

//Another Solution (permutation)
//import java.util.*;
//public class B6603 {
//	static boolean next_permutgetion(int[] a) {
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
//		while (true) {
//			int n = sc.nextInt();
//			if (n == 0) break;
//			int[] a = new int[n];
//			for (int i=0; i<n; i++) {
//				a[i] = sc.nextInt();
//			}
//			int[] d = new int[n];
//			for (int i=0; i<n; i++) {
//				if (i < n-6) d[i] = 0;
//				else d[i] = 1;
//			}
//			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//			do {
//				ArrayList<Integer> cur = new ArrayList<>();
//				for (int i=0; i<n; i++) {
//					if (d[i] == 1) {
//						cur.add(a[i]);
//					}
//				}
//				ans.add(cur);
//			} while (next_permutgetion(d));
//			Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
//				public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
//					int n = l1.size();
//					int m = l2.size();
//					int i = 0;
//					while (i < n && i < m) {
//						int t1 = l1.get(i);
//						int t2 = l2.get(i);
//						if (t1 < t2) return -1;
//						else if (t1 > t2) return 1;
//						i += 1;
//					}
//					if (i == n && i != m) return -1;
//					else if (i != n && i == m) return 1;
//					return 0;
//				}
//			});
//			for (ArrayList<Integer> v : ans) {
//				for (int x : v) {
//					System.out.print(x + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//	}
//}
