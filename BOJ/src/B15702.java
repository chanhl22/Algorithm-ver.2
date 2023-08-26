/**
 * playtime = 13:53
 */

import java.util.ArrayList;
import java.util.Scanner;

class Student15702 {
    int index;
    ArrayList<String> result;
    int total;

    public Student15702(int index, ArrayList<String> result) {
        this.index = index;
        this.result = result;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

public class B15702 {

    private static int n;
    private static int m;
    private static int[] scores;
    private static ArrayList<Student15702> students = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int index = sc.nextInt();
            ArrayList<String> result = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                result.add(sc.next());
            }
            students.add(new Student15702(index, result));
        }
    }

    private static void solution() {
        students.forEach(student -> {
            int total = 0;
            ArrayList<String> result = student.getResult();
            for (int i = 0; i < n; i++) {
                if (result.get(i).equals("O")) {
                    total += scores[i];
                }
            }
            student.setTotal(total);
        });

        students.sort((o1, o2) -> {
            if (o1.total == o2.total) {
                return o1.index - o2.index;
            }
            return o2.total - o1.total;
        });

        System.out.println(students.get(0).index + " " + students.get(0).total);
    }
}
