/**
 * playtime = 56:12
 */

import java.util.ArrayList;
import java.util.Scanner;

class Robot8896 {
    int number;
    String rsp;
    boolean status;

    public Robot8896(int number, String rsp, boolean status) {
        this.number = number;
        this.rsp = rsp;
        this.status = status;
    }

    public char getRsp(int index) {
        return rsp.charAt(index);
    }
}

public class B8896 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Robot8896> robots = new ArrayList<>();
            int size = 0;
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                robots.add(new Robot8896(i, input, true));
                size = input.length();
            }

            for (int i = 0; i < size; i++) {
                int r = 0;
                int s = 0;
                int p = 0;
                for (Robot8896 robot : robots) {
                    char rsp = robot.getRsp(i);
                    if (!robot.status) {
                        continue;
                    }
                    if (rsp == 'R') {
                        r++;
                    } else if (rsp == 'S') {
                        s++;
                    } else {
                        p++;
                    }
                }

                if (r == 0 && s == 0 || r == 0 && p == 0 || s == 0 && p == 0) {
                    continue;
                }

                if (r == 0) {
                    for (Robot8896 robot : robots) {
                        if (robot.getRsp(i) == 'P') {
                            robot.status = false;
                        }
                    }
                }

                if (s == 0) {
                    for (Robot8896 robot : robots) {
                        if (robot.getRsp(i) == 'R') {
                            robot.status = false;
                        }
                    }
                }

                if (p == 0) {
                    for (Robot8896 robot : robots) {
                        if (robot.getRsp(i) == 'S') {
                            robot.status = false;
                        }
                    }
                }
            }

            int result = 0;
            int count = 0;
            for (Robot8896 robot : robots) {
                if (robot.status) {
                    result = robot.number;
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(0);
            } else {
                System.out.println(result + 1);
            }
        }
    }
}
