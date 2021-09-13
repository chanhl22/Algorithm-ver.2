//import java.util.*;
//
//public class B14501 {
//	static int n;
//	static int[] t;
//	static int[] p;
//	static int ans = 0;
//	
//	static void go(int day, int sum) {
//		if(day == n + 1) {
//			if (ans < sum) {
//				ans = sum;
//			}
//			return ;
//		}
//		if(day > n + 1) {
//			return ;
//		}
//		go(day+t[day-1],sum+p[day-1]);
//		go(day+1, sum);
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		t = new int[n];
//		p = new int[n];
//		for (int i = 0; i < n; i++) {
//			t[i] = sc.nextInt();
//			p[i] = sc.nextInt();		
//		}
//		
//		go (1, 0);
//		System.out.println(ans);
//	}
//}

import java.util.Scanner;

public class B14501 {
    static final int inf = 100000000;
    static int[] t = new int[20];
    static int[] p = new int[20];
    static int[] d = new int[20];
    static int n;
    static int go(int day) {
        if (day == n+1) {
            return 0;
        }
        if (day > n+1) {
            return -inf;
        }
        if (d[day] != -1) {
            return d[day];
        }
        int t1 = go(day+1); // x
        int t2 = p[day] + go(day+t[day]); // o
        d[day] = Math.max(t1,t2);
        return d[day];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            d[i] = -1;
        }
        System.out.println(go(1));
    }
}