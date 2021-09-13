import java.util.ArrayList;
import java.util.Scanner;

class Pair32 {
    int x;
    int y;

    public Pair32(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B15684 {
    static int[][] garo = new int[100][100];
    static int n;
    static int h;

    static int start(int c) {
        for (int i = 1; i <= h; i++) {
            if (garo[i][c] == 1) {
                c += 1;
            } else if (garo[i][c] == 2){
                c -= 1;
            }
        }
        return c;
    }

    static boolean go() {
        for (int i = 0; i < n; i++) {
            int res = start(i);
            if (res != i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        h = sc.nextInt();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            garo[x][y] = 1;
            garo[x][y + 1] = 2;
        }
        //가능하면 다 arraylist에 담아줌
        ArrayList<Pair32> able = new ArrayList<>();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (garo[i][j] != 0) continue;
                if (garo[i][j + 1] != 0) continue;
                able.add(new Pair32(i, j));
            }
        }
        int ans = -1;
        int len = able.size();
        if(go()) {
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < len; i++) {
            int x1 = able.get(i).x;
            int y1 = able.get(i).y;
            if (garo[x1][y1] != 0 || garo[x1][y1 + 1] != 0) continue;
            garo[x1][y1] = 1;
            garo[x1][y1 + 1] = 2;
            if (go()) {
                if (ans == -1 || ans > 1) {
                    ans = 1;
                }
            }
            for (int j = i+1; j < len; j++) {
                int x2 = able.get(j).x;
                int y2 = able.get(j).y;
                if (garo[x2][y2] != 0 || garo[x2][y2 + 1] != 0) continue;
                garo[x2][y2] = 1;
                garo[x2][y2 + 1] = 2;
                if (go()) {
                    if (ans == -1 || ans > 2) {
                        ans = 2;
                    }
                }
                for (int k = j+1; k < len; k++) {
                    int x3 = able.get(k).x;
                    int y3 = able.get(k).y;
                    if (garo[x3][y3] != 0 || garo[x3][y3 + 1] != 0) continue;
                    garo[x3][y3] = 1;
                    garo[x3][y3 + 1] = 2;
                    if (go()) {
                        if (ans == -1 || ans > 3) {
                            ans = 3;
                        }
                    }
                    garo[x3][y3] = 0;
                    garo[x3][y3+1] = 0;
                }
                garo[x2][y2] = 0;
                garo[x2][y2+1] = 0;
            }
            garo[x1][y1] = 0;
            garo[x1][y1+1] = 0;
        }
        System.out.println(ans);
    }
}

//간단하게 arraylist를 배열로 옮기는 방법도 있음
//import java.util.*;
//class Pair {
//    int first;
//    int second;
//    Pair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}
//public class Main {
//    static int[][] garo = new int[100][100];
//    static int w, h;
//    static int start(int c) {
//        int r = 1;
//        while (r <= h) {
//            if (garo[r][c] == 1) {
//                c += 1;
//            } else if (garo[r][c] == 2) {
//                c -= 1;
//            }
//            r += 1;
//        }
//        return c;
//    }
//    static boolean go() {
//        for (int i=1; i<=w; i++) {
//            int res = start(i);
//            if (res != i) return false;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m;
//        w = sc.nextInt();
//        m = sc.nextInt();
//        h = sc.nextInt();
//        while (m-- > 0) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            garo[x][y] = 1;
//            garo[x][y+1] = 2;
//        }
//        ArrayList<Pair> temp = new ArrayList<>();
//        for (int i=1; i<=h; i++) {
//            for (int j=1; j<=w-1; j++) {
//                if (garo[i][j] != 0) continue;
//                if (garo[i][j+1] != 0) continue;
//                temp.add(new Pair(i,j));
//            }
//        }
//        Pair[] a = temp.toArray(new Pair[temp.size()]);
//        int ans = -1;
//        if (go()) {
//            System.out.println(0);
//            System.exit(0);
//        }
//        int len = a.length;
//        for (int i=0; i<len; i++) {
//            int x1 = a[i].first;
//            int y1 = a[i].second;
//            if (garo[x1][y1] != 0 || garo[x1][y1+1] != 0) continue;
//            garo[x1][y1] = 1;
//            garo[x1][y1+1] = 2;
//            if (go()) {
//                if (ans == -1 || ans > 1) {
//                    ans = 1;
//                }
//            }
//            for (int j=i+1; j<len; j++) {
//                int x2 = a[j].first;
//                int y2 = a[j].second;
//                if (garo[x2][y2] != 0 || garo[x2][y2+1] != 0) continue;
//                garo[x2][y2] = 1;
//                garo[x2][y2+1] = 2;
//                if (go()) {
//                    if (ans == -1 || ans > 2) {
//                        ans = 2;
//                    }
//                }
//                for (int k=j+1; k<len; k++) {
//                    int x3 = a[k].first;
//                    int y3 = a[k].second;
//                    if (garo[x3][y3] != 0 || garo[x3][y3+1] != 0) continue;
//                    garo[x3][y3] = 1;
//                    garo[x3][y3+1] = 2;
//                    if (go()) {
//                        if (ans == -1 || ans > 3) {
//                            ans = 3;
//                        }
//                    }
//                    garo[x3][y3] = 0;
//                    garo[x3][y3+1] = 0;
//                }
//                garo[x2][y2] = 0;
//                garo[x2][y2+1] = 0;
//            }
//            garo[x1][y1] = 0;
//            garo[x1][y1+1] = 0;
//        }
//        System.out.println(ans);
//    }
//}