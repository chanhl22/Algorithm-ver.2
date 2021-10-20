import java.util.Scanner;

public class B3029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        String input2 = sc.next();
        if (input1.equals(input2)) {
            System.out.println("24:00:00");
            System.exit(0);
        }
        String[] a = input1.split(":");
        String[] b = input2.split(":");
        int h = Integer.parseInt(b[0]) - Integer.parseInt(a[0]);
        int m = Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
        int s = Integer.parseInt(b[2]) - Integer.parseInt(a[2]);
        String ans_h = "";
        String ans_m = "";
        String ans_s = "";
        if (s < 0) {
            m--;
            s = 60 + s;
            if (s / 10 == 0) {
                ans_s += "0" + s;
            } else {
                ans_s += s;
            }
        } else {
            if (s / 10 == 0) {
                ans_s += "0" + s;
            } else {
                ans_s += s;
            }
        }
        if (m < 0) {
            h--;
            m = 60 + m;
            if (m / 10 == 0) {
                ans_m += "0" + m;
            } else {
                ans_m += m;
            }
        } else {
            if (m / 10 == 0) {
                ans_m += "0" + m;
            } else {
                ans_m += m;
            }
        }
        if (h < 0) {
            h = 24 + h;
            if (h / 10 == 0) {
                ans_h += "0" + h;
            } else {
                ans_h += h;
            }
        } else {
            if (h / 10 == 0) {
                ans_h += "0" + h;
            } else {
                ans_h += h;
            }
        }
        System.out.println(ans_h + ":" + ans_m + ":" + ans_s);
    }
}
