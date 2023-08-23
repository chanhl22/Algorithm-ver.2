/**
 * playtime = 10:04
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B11536 {

    private static int n;
    private static final List<String> inputList = new ArrayList<>();
    private static final List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void solution() {
        boolean flag = true;
        Collections.sort(stringList);
        for (int i = 0; i < n; i++) {
            if (!stringList.get(i).equals(inputList.get(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("INCREASING");
            return;
        }

        flag = true;
        stringList.sort(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (!stringList.get(i).equals(inputList.get(i))) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("DECREASING");
            return;
        }

        System.out.println("NEITHER");
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            inputList.add(input);
            stringList.add(input);
        }
    }
}
