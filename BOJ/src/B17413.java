import java.util.Scanner;
import java.util.Stack;

public class B17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean ok = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                ok = true;
                while(!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(s.charAt(i));
            } else if (s.charAt(i) == '>') {
                ok = false;
                System.out.print(s.charAt(i));
            } else if (ok) {
                System.out.print(s.charAt(i));
            } else if (!ok) {
                if (s.charAt(i) == ' ') {
                    while(!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(s.charAt(i));
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
