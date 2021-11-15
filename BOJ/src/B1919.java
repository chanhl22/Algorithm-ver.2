//playtime = 04:46

import java.util.Scanner;

public class B1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alpha1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            alpha2[s2.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(alpha1[i] - alpha2[i]);
        }
        System.out.println(ans);
    }
}
