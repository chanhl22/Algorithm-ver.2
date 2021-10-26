import java.util.Scanner;

public class B1652 {
    static char[][] arr;
    static int n;

    static int row(int x) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[x][i] == '.') {
                cnt++;
            }
            if (arr[x][i] == 'X') {
                if (cnt >= 2) {
                    res++;
                }
                cnt = 0;
            }
        }
        if (cnt >= 2) {
            res++;
        }
        return res;
    }

    static int col(int y) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][y] == '.') {
                cnt++;
            }
            if (arr[i][y] == 'X') {
                if (cnt >= 2) {
                    res++;
                }
                cnt = 0;
            }
        }
        if (cnt >= 2) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            r += row(i);
        }
        for (int j = 0; j < n; j++) {
            c += col(j);
        }
        System.out.println(r + " " + c);
    }
}

//Another Solution
//import java.util.*;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		char[][] map = new char[101][101];
//		int horizontal = 0; // 가로 개수
//		int vertical = 0; // 세로 개수
//
//		// 입력 받기
//		for(int i=0; i<n; i++) {
//			String s = sc.next();
//			for(int j=0; j<n; j++) {
//				map[i][j] = s.charAt(j);
//			}
//		}
//
//		// 가로, 세로 방향으로 누울 수 있는지 여부
//		for(int i=0; i<n; i++) {
//			int check_h = 0, check_v = 0;
//			for(int j=0; j<n; j++) {
//				// 가로 체크
//				if(map[i][j] == '.') check_h++;
//				if(map[i][j] == 'X' || (j == n-1)) {
//					if(check_h >= 2) horizontal++;
//					check_h = 0;
//				}
//
//				// 세로 체크
//				if(map[j][i] == '.') check_v++;
//				if(map[j][i] == 'X' || (j == n-1)) {
//					if(check_v >= 2) vertical++;
//					check_v = 0;
//				}
//			}
//		}
//		System.out.println(horizontal + " " + vertical);
//	}
//}
