//playtime = 01:33:28

import java.util.Scanner;
import java.util.Stack;

public class B10597 {
    static int MAX = 51;
    static Stack<Integer> stack = new Stack<>();
    static int len;
    static boolean[] visited;
    static String number;
    static int maxValue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        number = sc.next();
        len = number.length();
        visited = new boolean[MAX];
        if (len < 10) {
            maxValue = len;
        } else {
            maxValue = (len - 9) / 2 + 9;
        }
        go(0);
    }

    private static void go(int index) {
        if (index == len) {
            print();
            return;
        }

        String temp = number.substring(index, index + 1);
        if (Integer.parseInt(temp) < MAX && visited[Integer.parseInt(temp)] == false && Integer.parseInt(temp) <= maxValue) {
            visited[Integer.parseInt(temp)] = true;
            stack.push(Integer.parseInt(temp));
            go(index + 1);
            visited[Integer.parseInt(temp)] = false;
            stack.pop();
        }

        if (index <= len - 2) {
            temp = number.substring(index, index + 2);
            if (Integer.parseInt(temp) < MAX && visited[Integer.parseInt(temp)] == false && Integer.parseInt(temp) <= maxValue) {
                visited[Integer.parseInt(temp)] = true;
                stack.push(Integer.parseInt(temp));
                go(index + 2);
                visited[Integer.parseInt(temp)] = false;
                stack.pop();
            }
        }
    }

    private static void print() {
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.exit(0);
    }
}