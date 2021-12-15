//playtime = 20:00

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        Collections.sort(list);
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        String ret = "";
        for (int i = 0; i < n; i++) {
            String str = list.get(i);
            int value = map.getOrDefault(str, 0) + 1;
            map.put(str, value);
            if (ans < value) {
                ans = value;
                ret = str;
            }
        }
        System.out.println(ret);
    }
}
