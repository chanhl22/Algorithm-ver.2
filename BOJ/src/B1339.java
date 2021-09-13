import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B1339 {
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

    static int[] alpha = new int[128]; //Store the number that matches the character. ex) alpha['A'] = 9

    static int calc(String[] a, Character[] letters, int[] d) {
        int m = letters.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            alpha[letters[i]] = d[i];
        }
        for (String c : a) {
            int now = 0;
            for (char x : c.toCharArray()) {
                now = now * 10 + alpha[x];
            }
            sum += now;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[n];
        HashSet<Character> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
            for (char c : a[i].toCharArray()) {
                s.add(c);
            }
        }

        Character[] letters = s.toArray(new Character[s.size()]);
        int m = letters.length;
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = 9 - i;
        }
        Arrays.sort(d);

        int ans = 0;
        do {
            int cur = calc(a, letters, d);
            if (cur > ans) {
                ans = cur;
            }
        } while (next(d));
        System.out.println(ans);
    }
}
