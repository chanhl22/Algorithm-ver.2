import java.util.Scanner;

class Student2 {
    int index;
    int recommend;

    public Student2(int index, int recommend) {
        this.index = index;
        this.recommend = recommend;
    }
}

public class B1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n];
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        Student2[] p = new Student2[n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            //if (a[i] >)
            for (int j = 0; j < n; j++) {
               // if (a[i] == p[j].index)
            }
            p[i % n] = new Student2(a[i],1);
        }
    }
}
