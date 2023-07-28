/**
 * playtime = 15:36
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class B14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> mainString = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            mainString.put(input, 1);
        }

        List<String> findString = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = sc.next();
            findString.add(input);
        }

        int answer = 0;
        for (String key : findString) {
            Integer integer = mainString.get(key);
            if (integer != null) {
                answer += integer;
            }
        }

        System.out.println(answer);
    }
}
