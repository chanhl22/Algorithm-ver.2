import java.util.Scanner;

public class B6131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diff = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= 500; i++) {
            for (int j = i + 1; j <= 500; j++) {
                if (j * j - i * i > 1000) continue;
                if (j * j - i * i == diff) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
