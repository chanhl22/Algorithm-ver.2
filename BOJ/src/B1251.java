import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1251 {
    static ArrayList<String> a = new ArrayList<>();

    static void reverse(String[] str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringBuilder sb_reverse = new StringBuilder(str[i]);
            sb_reverse.reverse();
            sb.append(sb_reverse.toString());
        }
        a.add(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = new String[3];
        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                str[0] = s.substring(0, i);
                str[1] = s.substring(i, j);
                str[2] = s.substring(j);
                reverse(str);
            }
        }
        Collections.sort(a);
        System.out.println(a.get(0));
    }
}
