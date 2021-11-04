import java.util.Scanner;

public class B1138 {
    static boolean next(int[] d) {
        int i = d.length - 1;
        while (i > 0 && d[i] <= d[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = d.length - 1;
        while (d[i - 1] >= d[j]) {
            j--;
        }

        int temp = d[i - 1];
        d[i - 1] = d[j];
        d[j] = temp;

        j = d.length - 1;
        while (i < j) {
            temp = d[j];
            d[j] = d[i];
            d[i] = temp;
            i++;
            j--;
        }
        return true;
    }

    static boolean check (int[] cnt, int[] order, int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (order[i] < order[j]) {
                    count++;
                }
            }
            temp[order[i] - 1] = count;
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] != cnt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = i + 1;
        }
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = sc.nextInt();
        }
        do {
            boolean ok = check(cnt, order, n);
            if (ok) {
                for (int i = 0; i < n; i++) {
                    System.out.print(order[i] + " ");
                }
                break;
            }
        }while (next(order));
    }
}
