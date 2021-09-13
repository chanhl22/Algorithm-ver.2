import java.util.Scanner;

public class B12016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int index = 0;
        int time = 0;
        boolean ok = false;
        int[] ans = new int[n];
        while(true) {
            for (int i = 0; i < n; i++) {
                if (a[i] == 0){
                    ok = true;
                } else {
                    ok = false;
                    break;
                }
            }
            if (ok) break;
            if (a[index % n] == 0) {
                index += 1;
                continue;
            } else {
                a[index % n] -= 1;
                time += 1;
                if (a[index % n] == 0) {
                    ans[index % n] = time;
                }
            }
            index += 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
