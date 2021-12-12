//playtime = 55:08

import java.io.*;
import java.util.Stack;

public class B1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = s.length();
        int m = Integer.parseInt(br.readLine());
        Stack<Character> first = new Stack<>();
        Stack<Character> second = new Stack<>();
        for (int i = 0; i < n; i++) {
            first.push(s.charAt(i));
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            String[] command = str.split(" ");
            if (command[0].equals("L")) {
                if (first.size() != 0) {
                    second.push(first.pop());
                }
            } else if (command[0].equals("D")) {
                if (second.size() != 0) {
                    first.push(second.pop());
                }
            } else if (command[0].equals("B")) {
                if (first.size() != 0) {
                    first.pop();
                }
            } else if (command[0].equals("P")) {
                first.push(command[1].charAt(0));
            }
        }
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        for (int i = 0; i < first.size(); i++) {
            bw.write(first.get(i));
        }
        bw.flush();
        bw.close();
    }
}

//time out
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class B1406 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int n = s.length();
//        int m = sc.nextInt();
//        sc.nextLine();
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(s.charAt(i));
//        }
//        int cur = n;//현재 커서 위치
//        for (int i = 0; i < m; i++) {
//            String str = sc.nextLine();
//            String[] command = str.split(" ");
//            if (command[0].equals("L")) {
//                if (cur != 0) {
//                    cur--;
//                }
//            } else if (command[0].equals("D")) {
//                if (cur != list.size()) {
//                    cur++;
//                }
//            } else if (command[0].equals("B")) {
//                if (cur != 0) {
//                    list.remove(--cur);
//                }
//            } else if (command[0].equals("P")) {
//                list.add(cur, command[1].charAt(0));
//                cur++;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(list.get(i));
//        }
//        System.out.println(sb.toString());
//    }
//}
