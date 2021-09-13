//n * (n+1) <= 2000
//44*44 = 1936
//45*45 = 2025
import java.util.Scanner;

public class B10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[45];
        for (int i = 1; i < 45; i++) {
            a[i] = i*(i+1)/2;
        }
        int t = sc.nextInt();
        while(t-- > 0){
            boolean ok = false;
            int k = sc.nextInt();
            for (int i = 1; i < 45; i++) {
                for (int j = 1; j < 45; j++) {
                    for (int l = 1; l < 45; l++) {
                        if (a[i] + a[j] + a[l] == k) {
                            ok = true;
                        }
                    }

                }
            }
            if(ok){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
