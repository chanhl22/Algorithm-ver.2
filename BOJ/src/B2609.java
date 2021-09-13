import java.util.Scanner;

public class B2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int g = 0;
		int l = 0;
		int r = 0;
		int x = a;
		int y = b;
		while (true) {
			r = a % b;
			if (r == 0) {
				g = b;
				System.out.println(g);
				break;
			}
			a = b;
			b = r;
		}
		l = g * (x/g) * (y/g);
		System.out.println(l);
	}
}

/*
import java.util.*;

public class Main {
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int g = gcd(a, b);
        int l = a * b / g;
        System.out.println(g);
        System.out.println(l);
    }
}
*/