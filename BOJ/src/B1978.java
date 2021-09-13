import java.util.Scanner;

public class B1978 {
	public static boolean is_prime(int n) {
		if (n == 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i*i <= n; i++) {
			if(n%i==0) {
				return false;
			}				
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(is_prime(sc.nextInt())) {
				count++;
			}
		}
		System.out.println(count);
	}
}


/*

import java.util.*;
public class Main {
    public static boolean is_prime(int x) {
        if (x <= 1) {
            return false;
        } else if (x == 2) {
            return true;
        }
        for (int i=2; i*i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while (n-- > 0) {
            if (is_prime(sc.nextInt())) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

*/