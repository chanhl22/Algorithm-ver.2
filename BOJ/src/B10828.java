//playtime = 15:41

import java.util.ArrayList;
import java.util.Scanner;

public class B10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (input.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1);
                    sb.append("\n");
                } else {
                    sb.append(stack.remove(stack.size() - 1));
                    sb.append("\n");
                }
            } else if (input.equals("size")) {
                sb.append(stack.size());
                sb.append("\n");
            } else if (input.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1);
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            } else if (input.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1);
                    sb.append("\n");
                } else {
                    sb.append(stack.get(stack.size() - 1));
                    sb.append("\n");
                }
            } else {
                String[] temp = input.split(" ");
                stack.add(Integer.parseInt(temp[1]));
            }
        }
        System.out.println(sb.toString());
    }
}
