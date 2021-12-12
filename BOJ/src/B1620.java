//playtime : 01:11:26

import java.util.HashMap;
import java.util.Scanner;

public class B1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, i + 1);
            name[i] = s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String find = sc.next();
            if (map.containsKey(find)) {
                sb.append(map.get(find) + "\n");
            } else {
                sb.append(name[Integer.parseInt(find) - 1] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}

//Time out
//import java.util.Scanner;
//
//public class B1620 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        String[] arr = new String[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.next();
//        }
//        String[] ans = new String[m];
//        for (int i = 0; i < m; i++) {
//            ans[i] = sc.next();
//        }
//        for (int i = 0; i < m; i++) {
//            boolean isNumeric = ans[i].matches("[+-]?\\d*(\\.\\d+)?");
//            if (isNumeric == true) {
//                System.out.println(arr[Integer.parseInt(ans[i]) - 1]);
//            } else {
//                for (int j = 0; j < n; j++) {
//                    if (arr[j].equals(ans[i])) {
//                        System.out.println(j + 1);
//                    }
//                }
//            }
//        }
//    }
//}
