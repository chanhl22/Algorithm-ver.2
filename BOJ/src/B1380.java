/**
 * playtime = 09:08
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B1380 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scene_num = 1;

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            sc.nextLine();

            String[] name = new String[n];
            for (int i = 0; i < n; i++) {
                name[i] = sc.nextLine();
            }

            ArrayList<String> k = new ArrayList<>();

            for (int i = 0; i < 2 * n - 1; i++) {
                String num = sc.next();
                if (k.contains(num)) {
                    k.remove(num);
                } else {
                    k.add(num);
                }
                sc.next();
            }

            int tmp = Integer.parseInt(k.get(0)) - 1;
            System.out.println(scene_num + " " + name[tmp]);
            scene_num++;
        }
    }
}
