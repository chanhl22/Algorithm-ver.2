//import java.util.*;
//
//public class B14888 {
//	static int n;
//	static int max = Integer.MIN_VALUE;
//	static int min = Integer.MAX_VALUE;
//	
//	static int go1(int[] a, int index, int cur, int plus, int minus, int mul, int div){
//		if (index == n-1) {
//			if(cur > max) {
//				max = cur;
//				return max;
//			}
//		}
//		if (plus > 0) {
//			go1 (a,index+1,cur+a[index+1],plus-1,minus,mul,div);
//		}
//		if (minus > 0) {
//			go1 (a,index+1,cur-a[index+1],plus,minus-1,mul,div);
//		}
//		if (mul > 0) {
//			go1 (a,index+1,cur*a[index+1],plus,minus,mul-1,div);
//		}
//		if (div > 0) {
//			go1 (a,index+1,cur/a[index+1],plus,minus,mul,div-1);
//		}
//		return max;
//	}
//	
//	static int go2(int[] a, int index, int cur, int plus, int minus, int mul, int div){
//		if (index == n-1) {
//			if(cur < min) {
//				min = cur;
//				return min;
//			}
//		}
//		if (plus > 0) {
//			go2 (a,index+1,cur+a[index+1],plus-1,minus,mul,div);
//		}
//		if (minus > 0) {
//			go2 (a,index+1,cur-a[index+1],plus,minus-1,mul,div);
//		}
//		if (mul > 0) {
//			go2 (a,index+1,cur*a[index+1],plus,minus,mul-1,div);
//		}
//		if (div > 0) {
//			go2 (a,index+1,cur/a[index+1],plus,minus,mul,div-1);
//		}
//		return min;
//	}
//	
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int plus = sc.nextInt();
//        int minus = sc.nextInt();
//        int mul = sc.nextInt();
//        int div = sc.nextInt();
//        
//        int ans1 = go1(a, 0, a[0], plus, minus, mul, div);
//        System.out.println(ans1);
//        int ans2 = go2(a, 0, a[0], plus, minus, mul, div);
//        System.out.println(ans2);
//    }
//}

import java.util.ArrayList;
import java.util.Scanner;

class Pair7 {
    public int min, max;
    Pair7(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

public class B14888 {
    static Pair7 calc(int[] a, int index, int cur, int plus, int minus, int mul, int div) {
        int n = a.length;
        if (index == n) {
            return new Pair7(cur, cur);
        }
        ArrayList<Pair7> res = new ArrayList<>();
        if (plus > 0){
            res.add(calc(a,index+1,cur+a[index],plus-1,minus,mul,div));
        }
        if (minus > 0) {
            res.add(calc(a,index+1,cur-a[index],plus,minus-1,mul,div));
        }
        if (mul > 0) {
            res.add(calc(a,index+1,cur*a[index],plus,minus,mul-1,div));
        }
        if (div > 0) {
            res.add(calc(a,index+1,cur/a[index],plus,minus,mul,div-1));
        }
        Pair7 ans = res.get(0);
        for (Pair7 p : res) {
            if (ans.max < p.max) {
                ans.max = p.max;
            }
            if (ans.min > p.min) {
                ans.min = p.min;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        Pair7 ans = calc(a, 1, a[0], plus, minus, mul, div);
        System.out.println(ans.max);
        System.out.println(ans.min);
    }
}


//Solution by permutation
//import java.util.*;
//public class Main {
//    static boolean next_permutation(int[] a) {
//        int i = a.length-1;
//        while (i > 0 && a[i-1] >= a[i]) {
//            i -= 1;
//        }
//
//        if (i <= 0) {
//            return false;
//        }
//
//        int j = a.length-1;
//        while (a[j] <= a[i-1]) {
//            j -= 1;
//        }
//
//        int temp = a[i-1];
//        a[i-1] = a[j];
//        a[j] = temp;
//
//        j = a.length-1;
//        while (i < j) {
//            temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//            i += 1;
//            j -= 1;
//        }
//        return true;
//    }
//    static int calc(int[] a, int[] b) {
//        int n = a.length;
//        int ans = a[0];
//        for (int i=1; i<n; i++) {
//            if (b[i-1] == 0) {
//                ans = ans + a[i];
//            } else if (b[i-1] == 1) {
//                ans = ans - a[i];
//            } else if (b[i-1] == 2) {
//                ans = ans * a[i];
//            } else {
//                ans = ans / a[i];
//            }
//        }
//        return ans;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] b = new int[n-1];
//        int m = 0;
//        for (int i=0; i<4; i++) {
//            int cnt = sc.nextInt();
//            for (int k=0; k<cnt; k++) {
//                b[m++] = i;
//            }
//        }
//        Arrays.sort(b);
//        ArrayList<Integer> result = new ArrayList<>();
//        do {
//            int temp = calc(a, b);
//            result.add(temp);
//        } while(next_permutation(b));
//        Collections.sort(result);
//        m = result.size();
//        System.out.println(result.get(m-1));
//        System.out.println(result.get(0));
//    }
//}