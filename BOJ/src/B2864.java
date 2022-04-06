//playtime = 08:10

import java.util.Scanner;

public class B2864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        String minN = "";
        String maxN = "";
        String minM = "";
        String maxM = "";
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '5' || n.charAt(i) == '6') {
                minN += '5';
                maxN += '6';
            } else {
                minN += n.charAt(i);
                maxN += n.charAt(i);
            }
        }

        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) == '5' || m.charAt(i) == '6') {
                minM += '5';
                maxM += '6';
            } else {
                minM += m.charAt(i);
                maxM += m.charAt(i);
            }
        }
        int retMin = Integer.parseInt(minN) + Integer.parseInt(minM);
        int retMax = Integer.parseInt(maxN) + Integer.parseInt(maxM);
        System.out.println(retMin + " " + retMax);
    }
}
