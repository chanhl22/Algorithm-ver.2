import java.util.Scanner;

public class B5598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i) - 3;
            if (temp < 'A') {
                temp += 26;
            }
            sb.append((char)(temp));
        }
        System.out.println(sb.toString());
    }
}
