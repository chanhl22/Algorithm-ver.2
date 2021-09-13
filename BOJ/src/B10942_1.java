//Top-down
import java.io.*;
import java.util.Arrays;

public class B10942_1 {
    static int[] a;
    static int[][] d;

    static int go (int x, int y) {
        if (x == y) {
            return 1;
        } else if (x+1 == y){
            if (a[x] == a[y]){
                return 1;
            } else {
                return 0;
            }
        }
        if (d[x][y] != -1) {
            return d[x][y];
        }
        if (a[x] == a[y]) {
            return d[x][y] = go (x+1, y-1);
        }else {
            return d[x][y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        a = new int[n];
        String[] array1 = bf.readLine().split(" ");
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(array1[i]);
            Arrays.fill(d[i], -1);
        }
        int m = Integer.parseInt(bf.readLine());
        while (m-- > 0){
            String[] array2 = bf.readLine().split(" ");
            int i = Integer.parseInt(array2[0]);
            int j = Integer.parseInt(array2[1]);
            bw.write(Integer.toString(go(i-1,j-1)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

// Solution by StringBuilder
//import java.util.*;
//
//public class Main {
//    static int[] a;
//    static int[][] d;
//    public static int go(int x, int y) {
//        if (x == y) {
//            return 1;
//        } else if (x+1 == y) {
//            if (a[x] == a[y]) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//        if (d[x][y] != -1) {
//            return d[x][y];
//        }
//        if (a[x] != a[y]) {
//            return d[x][y] = 0;
//        } else {
//            return d[x][y] = go(x+1,y-1);
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        a = new int[n];
//        d = new int[n][n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.nextInt();
//            Arrays.fill(d[i],-1);
//        }
//        int m = sc.nextInt();
//        StringBuilder sb = new StringBuilder();
//        while (m-- > 0) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            sb.append(go(x-1,y-1));
//            sb.append('\n');
//        }
//        System.out.println(sb);
//    }
//}