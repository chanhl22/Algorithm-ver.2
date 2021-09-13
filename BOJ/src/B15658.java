import java.util.Scanner;

public class B15658 {
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static int go1(int[] a, int index, int cur, int plus, int minus, int mul, int div){
		if (index == n-1) {
			if(cur > max) {
				max = cur;
				return max;
			}
			return max;
		}
		if (plus > 0) {
			go1 (a,index+1,cur+a[index+1],plus-1,minus,mul,div);
		}
		if (minus > 0) {
			go1 (a,index+1,cur-a[index+1],plus,minus-1,mul,div);
		}
		if (mul > 0) {
			go1 (a,index+1,cur*a[index+1],plus,minus,mul-1,div);
		}
		if (div > 0) {
			go1 (a,index+1,cur/a[index+1],plus,minus,mul,div-1);
		}
		return max;
	}
	
	static int go2(int[] a, int index, int cur, int plus, int minus, int mul, int div){
		if (index == n-1) {
			if(cur < min) {
				min = cur;
				return min;
			}
			return min;
		}
		if (plus > 0) {
			go2 (a,index+1,cur+a[index+1],plus-1,minus,mul,div);
		}
		if (minus > 0) {
			go2 (a,index+1,cur-a[index+1],plus,minus-1,mul,div);
		}
		if (mul > 0) {
			go2 (a,index+1,cur*a[index+1],plus,minus,mul-1,div);
		}
		if (div > 0) {
			go2 (a,index+1,cur/a[index+1],plus,minus,mul,div-1);
		}
		return min;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        
        int ans1 = go1(a, 0, a[0], plus, minus, mul, div);
        System.out.println(ans1);
        int ans2 = go2(a, 0, a[0], plus, minus, mul, div);
        System.out.println(ans2);
    }
}
