/**
 * playtime = 1s 20m 48s
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B16926 {

    private static int n;
    private static int m;
    private static int r;
    private static int[][] a;

    public static void main(String[] args) {
        input();

        int groupK = calculateGroupK();
        ArrayList<ArrayList<Integer>> lists = flatArrays(groupK);
        move(lists);
        updateArrays(groupK, lists);

        output();
    }

    private static int calculateGroupK() {
        int k;
        int min = Math.min(n, m);
        if (min % 2 == 0) {
            k = min / 2;
        } else {
            k = min / 2 + 1;
        }
        return k;
    }

    private static ArrayList<ArrayList<Integer>> flatArrays(int groupK) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int k = 0; k < groupK; k++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = k; j < m - k - 1; j++) {
                list.add(a[k][j]);
            }

            for (int i = k; i < n - k - 1; i++) {
                list.add(a[i][m - k - 1]);
            }

            for (int j = m - k - 1; j > k; j--) {
                list.add(a[n - k - 1][j]);
            }

            for (int i = n - k - 1; i > k; i--) {
                list.add(a[i][k]);
            }

            lists.add(list);
        }
        return lists;
    }

    private static void move(ArrayList<ArrayList<Integer>> lists) {
        for (ArrayList<Integer> list : lists) {
            for (int i = 0; i < r; i++) {
                Integer remove = list.remove(0);
                list.add(remove);
            }
        }
    }

    private static void updateArrays(int groupK, ArrayList<ArrayList<Integer>> lists) {
        for (int k = 0; k < groupK; k++) {
            ArrayList<Integer> list = lists.get(k);

            for (int j = k; j < m - k - 1; j++) {
                a[k][j] = list.remove(0);
            }

            for (int i = k; i < n - k - 1; i++) {
                a[i][m - k - 1] = list.remove(0);
            }

            for (int j = m - k - 1; j > k; j--) {
                a[n - k - 1][j] = list.remove(0);
            }

            for (int i = n - k - 1; i > k; i--) {
                a[i][k] = list.remove(0);
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    private static void output() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class B16926 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int r = sc.nextInt();
//		int[][] a = new int[n][m];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				a[i][j] = sc.nextInt();
//			}
//		}
//		ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
//		int groupk = Math.min(m, n)/2;
//		for (int k = 0; k < groupk; k++) {
//			ArrayList<Integer> group = new ArrayList<>();
//			for (int j = k; j < m-k-1; j++) {
//				group.add(a[k][j]);
//			}
//			for (int i = k; i < n-k-1; i++) {
//				group.add(a[i][m-k-1]);
//			}
//			for (int j = m-k-1; j > k; j--) {
//				group.add(a[n-k-1][j]);
//			}
//			for (int i = n-k-1; i > k; i--) {
//				group.add(a[i][k]);
//			}
//			groups.add(group);
//		}
//		for (int k = 0; k < groupk; k++) {
//			ArrayList<Integer> group = groups.get(k);
//			int len = group.size();
//			int index = r % len;
//			for (int j = k; j < m-k-1; j++, index = (index+1) % len) { //index�� 1�����ϸ鼭 ���� ã�ƾ���
//				a[k][j] = group.get(index);
//			}
//			for (int i = k; i < n-k-1; i++, index = (index+1) % len) {
//				a[i][m-k-1] = group.get(index);
//			}
//			for (int j = m-k-1; j > k; j--, index = (index+1) % len) {
//				a[n-k-1][j] = group.get(index);
//			}
//			for (int i = n-k-1; i > k; i--, index = (index+1) % len) {
//				a[i][k] = group.get(index);
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//
//}
