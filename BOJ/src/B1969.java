/**
 * playtime = 15:06
 */

import java.util.Scanner;

public class B1969 {
    private static int n;
    private static int m;
    private static char[][] dna;
    private static StringBuilder result = new StringBuilder();
    private static int sum = 0;

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(result.toString());
        System.out.println(sum);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dna = new char[n][m];
        for (int i = 0; i < n; i++) {
            dna[i] = sc.next().toCharArray();
        }
    }

    private static void solution() {
        for (int i = 0; i < m; i++) {
            int[] count = new int[26];
            for (int j = 0; j < n; j++) {
                count[dna[j][i] - 'A']++;
            }
            int max = 0;
            int maxIndex = 0;
            for (int j = 0; j < 26; j++) {
                if (max < count[j]) {
                    max = count[j];
                    maxIndex = j;
                }
            }
            result.append((char) (maxIndex + 'A'));
            sum += n - count[maxIndex];
        }
    }
}
