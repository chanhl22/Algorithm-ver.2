import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Tuple1 implements Comparable<Tuple1> {
    int r;
    int c;
    int s;
    int index;

    public Tuple1(int r, int c, int s, int index) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.index = index;
    }

    @Override
    public int compareTo(Tuple1 that) {
        if (this.index > that.index) {
            return 1;
        } else if (this.index == that.index) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class B17406 {
    static boolean next_permutation(Tuple1[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1].compareTo(a[i]) >= 0) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[j].compareTo(a[i - 1]) <= 0) {
            j -= 1;
        }
        Tuple1 temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    static void go(int[][] a, Tuple1 t) {
        int row = t.r;
        int col = t.c;
        int size = t.s;
        //일차원 배열에 넣기
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int s = 1; s <= size; s++) {
            ArrayList<Integer> group = new ArrayList<>();
            //상
            for (int r = row - s, c = col - s; c < col + s; c++) {
                group.add(a[r][c]);
            }
            //우
            for (int r = row - s, c = col + s; r < row + s; r++) {
                group.add(a[r][c]);
            }
            //하
            for (int r = row + s, c = col + s; c > col - s; c--) {
                group.add(a[r][c]);
            }
            //좌
            for (int r = row + s, c = col - s; r > row - s; r--) {
                group.add(a[r][c]);
            }
            groups.add(group);
        }
        //일차원 배열에 넣었으면 회전
        for (int s = 1; s <= size; s++) {
            ArrayList<Integer> group = groups.get(s-1);
            Collections.rotate(group, 1);
            int index = 0;
            //상
            for (int r = row - s, c = col - s; c < col + s; c++) {
                a[r][c] = group.get(index);
                index++;
            }
            //우
            for (int r = row - s, c = col + s; r < row + s; r++) {
                a[r][c] = group.get(index);
                index++;
            }
            //하
            for (int r = row + s, c = col + s; c > col - s; c--) {
                a[r][c] = group.get(index);
                index++;
            }
            //좌
            for (int r = row + s, c = col - s; r > row - s; r--) {
                a[r][c] = group.get(index);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Tuple1[] d = new Tuple1[k];
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int s = sc.nextInt();
            d[i] = new Tuple1(r, c, s, i);
        }
        int ans = Integer.MAX_VALUE;
        do {
            int[][] b = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    b[i][j] = a[i][j];
                }
            }
            for (Tuple1 t : d) {
                go(b, t);
            }
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += b[i][j];
                }
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while (next_permutation(d));
        System.out.println(ans);
    }
}
