//playtime = 14:35

import java.util.Scanner;

public class B2511 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            b[i] = sc.nextInt();
        }
        int aSum = 0;
        int bSum = 0;
        int aDiffCheck = 0;
        int bDiffCheck = 0;
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) {
                aDiffCheck = a[i];
                bDiffCheck = b[i];
            }
            if (a[i] > b[i]) {
                aSum += 3;
            } else if (a[i] < b[i]) {
                bSum += 3;
            } else {
                aSum++;
                bSum++;
            }
        }
        System.out.println(aSum + " " + bSum);
        if (aSum > bSum) {
            System.out.println("A");
        } else if (aSum < bSum) {
            System.out.println("B");
        } else {
            if (aDiffCheck > bDiffCheck) {
                System.out.println("A");
            } else if (aDiffCheck < bDiffCheck) {
                System.out.println("B");
            } else {
                System.out.println("D");
            }
        }
    }
}
