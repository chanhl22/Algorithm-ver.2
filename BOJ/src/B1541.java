import java.util.Scanner;

public class B1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] minus = str.split("-");
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minus.length; i++) {
            String[] plus = minus[i].split("\\+");
            int temp = 0;
            for (int j = 0; j < plus.length; j++) {
                temp += Integer.parseInt(plus[j]);
            }
            if (ans == Integer.MAX_VALUE) {
                ans = temp;
            } else {
                ans -= temp;
            }
        }
        System.out.println(ans);
    }
}