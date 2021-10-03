import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<BigInteger> a = new ArrayList<>();
        while (n-- > 0) {
            String[] s = sc.next().split("\\D");
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("")) {
                    continue;
                }
                a.add(new BigInteger(s[i]));
            }
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
