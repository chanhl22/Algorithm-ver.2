import java.util.Scanner;

public class B16917 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        //int ans = x*a+y*b;
        for (int i = 0; i <= 100000; i++) {
            int temp = 2 * i * c + Math.max(0,(x - i)) * a + Math.max(0,(y - i)) * b;
            if (ans > temp) {
                ans = temp;
            }
        }
        System.out.println(ans);
    }
}
