import java.util.Scanner;

public class B21567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long ans = a * b * c;
        String s = Long.toString(ans);
        int[] num_count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            num_count[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(num_count[i]);
        }
    }
}
