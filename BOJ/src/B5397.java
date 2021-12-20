//playtime = 27:51

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            Stack<Character> answer = new Stack<>();
            Stack<Character> temp = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '<') {
                    if (!answer.isEmpty()) {
                        temp.push(answer.pop());
                    }
                } else if (c == '>') {
                    if (!temp.isEmpty()) {
                        answer.push(temp.pop());
                    }
                } else if (c == '-') {
                    if (!answer.isEmpty()) {
                        answer.pop();
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    answer.push(c);
                } else if (c >= 'a' && c <= 'z') {
                    answer.push(c);
                } else if (c >= '0' && c <= '9') {
                    answer.push(c);
                }
            }
            while (!temp.isEmpty()) {
                answer.push(temp.pop());
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.elementAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
