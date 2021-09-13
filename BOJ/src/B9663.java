import java.util.Scanner;

public class B9663 {
	static int n;
	static int ans = 0;
	static boolean[] check_col;
	static boolean[] check_dig1;
	static boolean[] check_dig2;
	
	static boolean check(int row, int col) {
		if (check_col[col]) {
			return false;
		}
		if (check_dig1[row + col]) {
			return false;
		}
		if (check_dig2[n + row - col]) {
			return false;
		}
		return true;
	}
	
	static void go(int row) {
		if(row == n) {
			ans += 1;
		}
		for (int col = 0; col < n; col++) {
			// if check returns false, no more numbers can be placed
			if (check(row, col)) {
				check_col[col] = true; //column check
				check_dig1[row + col] = true; // / check
				check_dig2[n+ row - col] = true; // \ check
				go(row + 1);
				check_col[col] = false;
				check_dig1[row + col] = false;
				check_dig2[n+ row - col] = false;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		check_col = new boolean[n];
		check_dig1 = new boolean[2 * n + 1];
		check_dig2 = new boolean[2 * n + 1];
		
		go(0);

		System.out.println(ans);
	}

}

//import java.util.*;
//public class Main {
//    static boolean[][] a = new boolean[15][15];
//    static int n;
//    static int ans = 0;
//    static boolean check(int row, int col) {
//        // |
//        for (int i=0; i<n; i++) {
//            if (i == row) continue;
//            if (a[i][col]) {
//                return false;
//            }
//        }
//        // ���� �� �밢��
//        int x = row-1;
//        int y = col-1;
//        while (x >=0 && y >=0) {
//            if (a[x][y] == true) {
//                return false;
//            }
//            x -= 1;
//            y -= 1;
//        }
//        // /
//        x = row-1;
//        y = col+1;
//        while (x >=0 && y < n) {
//            if (a[x][y] == true) {
//                return false;
//            }
//            x -=1;
//            y += 1;
//        }
//        return true;
//    }
//    static void calc(int row) {
//        if (row == n) {
//            ans += 1;
//        }
//        for (int col=0; col<n; col++) {
//            a[row][col] = true;
//            if (check(row, col)) {
//                calc(row+1);
//            }
//            a[row][col] = false;
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        calc(0);
//        System.out.println(ans);
//    }
//}
