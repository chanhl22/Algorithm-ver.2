import java.util.Scanner;

public class B2502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int k = sc.nextInt();
        int[] da = new int[31];
        int[] db = new int[31];
        da[1] = 1;
        db[2] = 1;
        for (int i = 3; i < 31; i++) {
            da[i] = da[i-1] + da[i-2];
            db[i] = db[i-1] + db[i-2];
        }
        int cur_a = da[day];
        int cur_b = db[day];
        for (int a = 0; a < 100000; a++) {
            if ((k - cur_a * a) % cur_b == 0) {
                int b = (k - cur_a * a) / cur_b;
                System.out.println(a);
                System.out.println(b);
                break;
            }
        }
    }
}
