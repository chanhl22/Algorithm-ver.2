import java.util.Scanner;

public class B3085 {
	static int check(char[][] a) {
		int res = 1;
		for (int i = 0; i < a.length; i++) {
			int count = 1;
			for (int j = 1; j < a.length; j++) {
				if (a[i][j-1] == a[i][j])
					count++;
				else 
					count = 1;
				if (res < count)
					res = count;
			}
			count = 1;
			for (int j = 1; j < a.length; j++) {
				if (a[j-1][i] == a[j][i])
					count++;
				else
					count = 1;
				if (res < count)
					res = count;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j+1 < n) {
					char temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
					int value = check(arr);
					if (res < value)
						res = value;
					temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
				}
				if (i+1 < n) {
					char temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
					int value = check(arr);
					if (res < value)
						res = value;
					temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
				}
			}
		}
		System.out.println(res);
	}
}

//import java.util.*;
//public class Main {
//    static int check(char[][] a, int start_row, int end_row, int start_col, int end_col) {
//        int n = a.length;
//        int ans = 1;
//        for (int i=start_row; i<=end_row; i++) {
//            int cnt = 1;
//            for (int j=1; j<n; j++) {
//                if (a[i][j] == a[i][j-1]) {
//                    cnt += 1;
//                } else {
//                    cnt = 1;
//                }
//                if (ans < cnt) ans = cnt;
//            }
//        }
//        for (int i=start_col; i<=end_col; i++) {
//            int cnt = 1;
//            for (int j=1; j<n; j++) {
//                if (a[j][i] == a[j-1][i]) {
//                    cnt += 1;
//                } else {
//                    cnt = 1;
//                }
//                if (ans < cnt) ans = cnt;
//            }
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[][] a = new char[n][n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.next().toCharArray();
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                if (j+1 < n) {
//                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
//                    int temp = check(a, i, i, j, j+1);
//                    if (ans < temp) ans = temp;
//                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
//                }
//                if (i+1 < n) {
//                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
//                    int temp = check(a, i, i+1, j, j);
//                    if (ans < temp) ans = temp;
//                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}
