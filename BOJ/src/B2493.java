//playtime = 53:48

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair37 {
    int high;
    int index;

    public Pair37(int high, int index) {
        this.high = high;
        this.index = index;
    }
}

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Pair37> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String[] s = str.split(" ");
        for (int i = 1; i <= k; i++) {
            int num = Integer.parseInt(s[i - 1]);
            while (!stack.isEmpty()) {
                if (stack.peek().high < num) {
                    stack.pop();
                } else {
                    sb.append(stack.peek().index + " ");
                    break;
                }
            }
            if (stack.isEmpty()) {
                sb.append(0 + " ");
            }
            stack.push(new Pair37(num, i));
        }
        System.out.println(sb.toString());
    }
}
