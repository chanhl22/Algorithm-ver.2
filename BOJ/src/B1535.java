import java.util.Scanner;

public class B1535 {
    static int n;
    static int[] h;
    static int[] f;

    static int go(int index, int sum, int check) { //sum : feeling, check : health
        if (index == n) {
            if (check >= 100) {
                return 0;
            } else {
                return sum;
            }
        }
        int temp1 = go(index + 1, sum + f[index], check + h[index]);
        int temp2 = go(index + 1, sum, check);
        return Math.max(temp1, temp2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = new int[n]; //health
        f = new int[n]; //feeling
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
        }
        System.out.println(go(0, 0, 0));
    }
}
