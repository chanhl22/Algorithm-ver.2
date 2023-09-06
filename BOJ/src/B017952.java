/**
 * playtime = 40:51
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Homework {
    int score;
    int time;

    public Homework(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class B017952 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int total = 0;
        Stack<Homework> remain = new Stack<>();
        while (n-- > 0) {
            String tf = bf.readLine();
            String[] input = tf.split(" ");
            if (Integer.parseInt(input[0]) == 0) {
                if (!remain.isEmpty()) {
                    Homework homework = remain.peek();
                    homework.time--;
                    if (homework.time == 0) {
                        total += homework.score;
                        remain.pop();
                    }
                }
            } else {
                int a = Integer.parseInt(input[1]);
                int t = Integer.parseInt(input[2]);
                Homework homework = new Homework(a, t);
                if (t != 1) {
                    homework.time--;
                    remain.push(homework);
                } else {
                    total += homework.score;
                }
            }
        }

        System.out.println(total);
    }
}
