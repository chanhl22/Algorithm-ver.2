import java.util.Scanner;

class Student7568 {
    int w;
    int h;

    public Student7568(int w, int h) {
        this.w = w;
        this.h = h;
    }
}

public class B7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student7568[] s = new Student7568[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y= sc.nextInt();
            s[i] = new Student7568(x,y);
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if (s[i].w < s[j].w && s[i].h < s[j].h) {
                    cnt += 1;
                }
            }
            rank[i] = cnt;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(rank[i] + 1 + " ");
        }
    }
}
