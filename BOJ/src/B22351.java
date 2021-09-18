import java.util.Scanner;

public class B22351 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 1; i <= 999; i++) {
            String str = s;
            boolean ok = false;
            String temp1 = Integer.toString(i);
            if (str.startsWith(temp1)) {
                for (int j = i; j <= 999; j++) {
                    String temp2 = Integer.toString(j);
                    if (str.startsWith(temp2)) {
                        str = str.substring(temp2.length());
                    } else {
                        break;
                    }
                    if (str.equals("")) {
                        System.out.println(temp1 + " " + temp2);
                        ok = true;
                    }
                }
            }
            if (ok) {
                break;
            }
        }
    }
}
