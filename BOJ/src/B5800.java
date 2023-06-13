/**
 * playtime = 05:28
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B5800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int index = 1;
        while (k-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> score = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                score.add(sc.nextInt());
            }
            score.sort((o1, o2) -> o2 - o1);

            int gap = 0;
            for (int i = 0; i < score.size() - 1; i++) {
                if (gap < score.get(i) - score.get(i + 1)) {
                    gap = score.get(i) - score.get(i + 1);
                }
            }

            System.out.println("Class " + index++);
            System.out.println("Max " + score.get(0) + ", Min " + score.get(n - 1) + ", Largest gap " + gap);
        }
    }
}
