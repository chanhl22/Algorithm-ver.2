import java.util.Scanner;

public class B12869 {
    static int [][][] d;

    static int go(int x, int y, int z) {
        if (x < 0) return go(0, y, z);
        if (y < 0) return go(x, 0, z);
        if (z < 0) return go(x, y, 0);
        if (x == 0 && y == 0 && z == 0) return 0;
        if (d[x][y][z] != -1) return d[x][y][z];
        int ans = Integer.MAX_VALUE;
        if (ans > go(x-1,y-3,z-9)){
            ans = go(x-1,y-3,z-9);
        }
        if (ans > go(x-1,y-9,z-3)){
            ans = go(x-1,y-9,z-3);
        }
        if (ans > go(x-3,y-1,z-9)){
            ans = go(x-3,y-1,z-9);
        }
        if (ans > go(x-3,y-9,z-1)){
            ans = go(x-3,y-9,z-1);
        }
        if (ans > go(x-9,y-1,z-3)){
            ans = go(x-9,y-1,z-3);
        }
        if (ans > go(x-9,y-3,z-1)){
            ans = go(x-9,y-3,z-1);
        }
        ans += 1;
        d[x][y][z] = ans;
        return d[x][y][z];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[3];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        d = new int[61][61][61];
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                for (int k = 0; k < 61; k++) {
                    d[i][j][k] = -1;
                }
            }
        }
        System.out.println(go(a[0], a[1], a[2]));
    }
}
