//playtime = 02:20:00

import java.util.ArrayList;
import java.util.Scanner;

public class B1786 {
    static int cnt = 0;
    static ArrayList<Integer> position = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parent = sc.nextLine();
        String pattern = sc.nextLine();
        kmp(parent, pattern);
        System.out.println(cnt);
        for (int i = 0; i < position.size(); i++) {
            System.out.print(position.get(i) + " ");
        }
    }

    private static void kmp(String parent, String pattern) {
        int[] table = makeTable(pattern);
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int j = 0;
        for (int i = 0; i < parentSize; i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if(parent.charAt(i) == pattern.charAt(j)) {
                if (j == patternSize - 1) {
                    j = table[j];
                    cnt++;
                    position.add(i - patternSize + 2);
                } else {
                    j++;
                }
            }
        }
    }

    private static int[] makeTable(String pattern) {
        int patternSize = pattern.length();
        int[] table = new int[patternSize];
        int j = 0;
        for (int i = 1; i < patternSize; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }
}
