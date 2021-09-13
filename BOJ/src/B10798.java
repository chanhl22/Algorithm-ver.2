import java.util.ArrayList;
import java.util.Scanner;

public class B10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String>[] a = new ArrayList[5];
        int max_size = 0;
        for (int i = 0; i < 5; i++) {
            String s = sc.nextLine();
            a[i] = new ArrayList<>();
            a[i].add(s);
            if (max_size < s.length()) {
                max_size = s.length();
            }
        }
        String ans = "";
        for (int i = 0; i < max_size; i++) { //각 단어의 인덱스
            for (int j = 0; j < 5; j++) { //한 줄에 대한 인덱스
                if (i >= a[j].get(0).length()) continue;
                ans += a[j].get(0).charAt(i);
            }
        }
        System.out.println(ans);
    }
}

//Another Solution
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[][] input = new char[5][15];
//        int max_length = Integer.MIN_VALUE;
//
//        for(int i = 0; i < 5; i++) {
//            String s = sc.nextLine().trim();
//            max_length = Math.max(max_length, s.length());
//            for(int j = 0; j < s.length(); j++) {
//                input[i][j] = s.charAt(j);
//            }
//        }
//        for(int i = 0; i < max_length; i++) {
//            for(int j = 0; j < 5; j++) {
//                if(input[j][i] == '\0')
//                    continue;
//                System.out.print(input[j][i]);
//            }
//        }
//    }
//}
