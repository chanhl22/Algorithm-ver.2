import java.util.Arrays;
import java.util.Scanner;

class Pair19 implements Comparable<Pair19> {
    int three;
    long num;

    public Pair19(int three, long num) {
        this.three = three;
        this.num = num;
    }

    @Override
    public int compareTo(Pair19 that) {
        if (this.three > that.three) {
            return -1;
        } else if (this.three == that.three) {
            if (this.num > that.num) {
                return 1;
            } else if (this.num == that.num) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }
}

public class B16936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair19[] a = new Pair19[n];
        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            int three = 0;
            for (long j = num; j % 3 == 0; j /= 3) {
                three += 1;
            }
            a[i] = new Pair19(three, num);
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i].num + " ");
        }
        System.out.println();
    }
}
