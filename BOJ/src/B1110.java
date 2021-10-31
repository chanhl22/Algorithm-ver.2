import java.util.Scanner;

public class B1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //26 68 84 42 26
        int temp = n;
        int cnt = 0;
        while (true) {
            int num = 0;
            if (temp < 10) {
                int temp1 = 0;
                int temp2 = temp;
                num = (temp1 + temp2) % 10;
                temp = temp2 * 10 + num;
            } else {
                int temp1 = temp / 10;
                int temp2 = temp % 10;
                num = (temp1 + temp2) % 10;
                temp = temp2 * 10 + num;
            }
            cnt++;
            if (temp == n) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
