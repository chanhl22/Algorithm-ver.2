import java.util.Arrays;
import java.util.Scanner;

class Student3 implements Comparable<Student3> {
    int score;
    int count;
    int time;
    int index;

    public Student3(int score, int count, int time, int index) {
        this.score = score;
        this.count = count;
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Student3 that) {
        if (this.score < that.score) {
            return 1;
        } else if (this.score == that.score) {
            if (this.count < that.count) {
                return -1;
            } else if (this.count == that.count) {
                if (this.time < that.time) {
                    return -1;
                } else if (this.time == that.time) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }
}

public class B14593 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student3[] student = new Student3[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt();
            student[i] = new Student3(s, c, t, i);
        }
        Arrays.sort(student);
        System.out.println(student[0].index + 1);
    }
}
