//playtime = more than 2 hours

import java.util.Scanner;

public class B15501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            if (b[i] == a[0]) {
                start = i;
            }
        }
        boolean same = true; //오름차순
        for (int i = 0; i < n; i++) {
            if (a[i] != b[(start + i) % n]) {
                same = false; //내림차순
                break;
            }
        }
        if (same) {
            System.out.println("good puzzle");
        } else {
            int[] temp = new int[n];
            for (int i = n - 1, j = 0; i >= 0; i--, j++) {
                temp[j] = b[i];
                if (temp[j] == a[0]) {
                    start = j;
                }
            }
            same = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != temp[(start + i) % n]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                System.out.println("good puzzle");
            } else {
                System.out.println("bad puzzle");
            }
        }
    }
}