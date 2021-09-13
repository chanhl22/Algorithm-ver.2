import java.util.Arrays;
import java.util.Scanner;

public class B11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] str = new String[s.length()];
        StringBuilder sb = new StringBuilder(s);
        str[0] = sb.toString();
        for (int i = 1; i < s.length(); i++) {
            sb.deleteCharAt(0);
            str[i] = sb.toString();
        }
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}

//Another Solution (substring)
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String s = br.readLine();
//        String[] strArray = new String[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            strArray[i] = s.substring(i,s.length());
//        }
//        Arrays.sort(strArray);
//        for(String str : strArray) {
//            bw.write(str);
//            bw.write('\n');
//        }
//        bw.flush();
//    }
//}

//Another Solution (split)
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) { // 11656번 접미사 배열
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] S = str.split("");
//        String[] sum = S;
//        for (int i = 0; i < S.length; i++) {
//            for (int j = i + 1; j < S.length; j++) {
//                sum[i] += S[j];
//            }
//        }
//        Arrays.sort(sum);
//        for (int i = 0; i < sum.length; i++) {
//            System.out.println(sum[i]);
//        }
//    }
//}