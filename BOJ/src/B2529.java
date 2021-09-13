import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2529 {
	static int n;
	static String[] a = new String[9];
	static ArrayList<String> ans = new ArrayList<String>();
	static boolean[] check = new boolean[10];
	
	static boolean good(char x, char y, String op) {
		if(op.equals("<")) {
			if(x > y) return false;
		}
		else if(op.equals(">")) {
			if(x < y) return false;
		}
		return true;
	}
	
	static void go(int index, String num) {
		if (index == n+1) {
			ans.add(num);
			return ;
		}
		
		for (int i = 0; i < 10; i++) {
			if(check[i]) continue;
			if (index == 0 || good(num.charAt(index-1), (char)(i+'0'), a[index-1])) {
				check[i] = true;
				go (index + 1, num + Integer.toString(i));				
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
		}
		
		go(0, "");
		Collections.sort(ans);
		int m = ans.size();
		System.out.println(ans.get(m-1));
		System.out.println(ans.get(0));
		
	}
}

//import java.util.*;
//
//public class B2529 {
//	static int n;
//	static String[] a = new String[9];
//	static ArrayList<String> ans = new ArrayList<String>();
//	static boolean[] check = new boolean[10];
//	
//	static boolean ok(String num) {
//		for (int i = 0; i < n; i++) {
//			if(a[i].equals("<")) {
//				if(num.charAt(i) > num.charAt(i+1)) {
//					return false;
//				}
//			}
//			else if (a[i].equals(">")) {
//				if(num.charAt(i) < num.charAt(i+1)) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//	
//	static void go(int index, String num) {
//		if (index == n+1) {
//			if(ok(num))
//				ans.add(num);
//			return ;
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			if(check[i]) continue;
//			check[i] = true;
//			go (index + 1, num + Integer.toString(i));
//			check[i] = false;
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			a[i] = sc.next();
//		}
//		
//		go(0, "");
//		Collections.sort(ans);
//		int m = ans.size();
//		System.out.println(ans.get(m-1));
//		System.out.println(ans.get(0));
//		
//	}
//}

/*
import java.util.*;

public class Main {
    static int n;
    static char[] a = new char[20];
    static ArrayList<String> ans = new ArrayList<>();
    static boolean[] check = new boolean[10];
    static boolean ok(String num) {
        for (int i=0; i<n; i++) {
            if (a[i] == '<') {
                if (num.charAt(i) > num.charAt(i+1)) return false;
            } else if (a[i] == '>') {
                if (num.charAt(i) < num.charAt(i+1)) return false;
            }
        }
        return true;
    }
    static void go(int index, String num) {
        if (index == n+1) {
            if (ok(num)) {
                ans.add(num);
            }
            return;
        }
        for (int i=0; i<=9; i++) {
            if (check[i]) continue;
            check[i] = true;
            go(index+1, num+Integer.toString(i));
            check[i] = false;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray()[0];
        }
        go(0, "");
        Collections.sort(ans);
        int m = ans.size();
        System.out.println(ans.get(m-1));
        System.out.println(ans.get(0));
    }
}
*/

// Soluiton by Permutation
//import java.util.*;
//public class Main {
//	static boolean prev_permutation(int[] a) {
//		int i = a.length-1;
//		while (i > 0 && a[i-1] <= a[i]) {
//			i -= 1;
//		}
//
//		if (i <= 0) {
//			return false;
//		}
//
//		int j = a.length-1;
//		while (a[j] >= a[i-1]) {
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
//	static boolean check(int[] perm, char[] a) {
//		for (int i=0; i<a.length; i++) {
//			if (a[i] == '<' && perm[i] > perm[i+1]) {
//				return false;
//			}
//			if (a[i] == '>' && perm[i] < perm[i+1]) {
//				return false;
//			}
//		}
//		return true;
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int k = sc.nextInt();
//		char[] a = new char[k];
//		for (int i=0; i<k; i++) {
//			a[i] = sc.next().charAt(0);
//		}
//		int[] small = new int[k+1];
//		int[] big = new int[k+1];
//		for (int i=0; i<=k; i++) {
//			small[i] = i;
//			big[i] = 9-i;
//		}
//		do {
//			if (check(small, a)) {
//				break;
//			}
//		} while(next_permutation(small));
//		do {
//			if (check(big, a)) {
//				break;
//			}
//		} while(prev_permutation(big));
//		for (int i=0; i<big.length; i++) {
//			System.out.print(big[i]);
//		}
//		System.out.println();
//		for (int i=0; i<small.length; i++) {
//			System.out.print(small[i]);
//		}
//		System.out.println();
//	}
//}