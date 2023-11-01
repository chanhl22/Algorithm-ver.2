/**
 * playtime = 10:59
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Score10825 {
    String name;
    int korean;
    int english;
    int math;

    public Score10825(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class B10825 {

    private static List<Score10825> scores = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            scores.add(new Score10825(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }

    private static void solution() {
        scores.sort((o1, o2) -> {
            if (o1.korean == o2.korean) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        return o2.math - o1.math;
                    }
                } else {
                    return o1.english - o2.english;
                }
            } else {
                return o2.korean - o1.korean;
            }
        });

        for (Score10825 score : scores) {
            System.out.println(score.name);
        }
    }
}
