//import java.util.Scanner;
//
//public class B9933 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        sc.nextLine();
//        String[] str = new String[t];
//        String[] reverse = new String[t];
//        for (int i = 0; i < t; i++) {
//            str[i] = sc.nextLine();
//            String ans = "";
//            for (int j = str[i].length() - 1; j >= 0; j--) {
//                ans += String.valueOf(str[i].charAt(j));
//            }
//            reverse[i] = ans;
//        }
//        for (int i = 0; i < t; i++) {
//            for (int j = 0; j < t; j++) {
//                if (str[i].equals(reverse[j])) {
//                    System.out.print(reverse[j].length() + " ");
//                    System.out.println(reverse[i].charAt(reverse[j].length() / 2));
//                    System.exit(0);
//                }
//            }
//        }
//    }
//}

//Another Solution
import java.util.Scanner;

public class B9933 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] str = new String[t];
        for (int i = 0; i < t; i++) {
            str[i] = sc.nextLine();
        }
        int result1 = 0;
        char result2 = '0';

        for (int i = 0; i < t; i++) {
            String reverse = (new StringBuilder(str[i])).reverse().toString();
            for (int j = i; j < t; j++) {
                if (reverse.equals(str[j])) {
                    result1 = reverse.length();
                    result2 = reverse.charAt((reverse.length() / 2));
                    break;
                }
                if (result2 != '0') break;
            }
        }
        System.out.println(result1 + " " + result2);
    }
}