/**
 * 49:05
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B10431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> students = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                int input = sc.nextInt();
                students.add(input);
                temp.add(input);
            }

            Collections.sort(temp);

            int result = 0;
            while (!isSame(temp, students)) {
                boolean flag = false;
                for (int i = 0; i <= 18; i++) {
                    for (int j = i + 1; j <= 19; j++) {
                        if (students.get(i) > students.get(j)) {
                            int remove = students.remove(j);
                            students.add(i, remove);
                            result += j - i;
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }

            System.out.println(n + " " + result);
        }
    }

    private static boolean isSame(ArrayList<Integer> temp, ArrayList<Integer> students) {
        for (int i = 0; i < 20; i++) {
            if ((int) temp.get(i) != (int) students.get(i)) {
                return false;
            }
        }
        return true;
    }
}
