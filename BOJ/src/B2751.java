//playtime = 14:05

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num.add(sc.nextInt());
        }
        Collections.sort(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(num.get(i));
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
