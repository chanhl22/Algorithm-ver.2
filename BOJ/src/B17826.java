//playtime = 05:03

import java.util.Scanner;

public class B17826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[51];
        int index = 0;
        for (int i = 1; i <= 50; i++) {
            score[i] = sc.nextInt();
        }
        int hong = sc.nextInt();
        for (int i = 1; i <= 50; i++) {
            if (score[i] == hong) {
                index = i;
            }
        }
        if (index >= 1 && index <= 5) {
            System.out.println("A+");
        } else if (index <= 15) {
            System.out.println("A0");
        } else if (index <= 30) {
            System.out.println("B+");
        } else if (index <= 35) {
            System.out.println("B0");
        } else if (index <= 45) {
            System.out.println("C+");
        } else if (index <= 48) {
            System.out.println("C0");
        } else {
            System.out.println("F");
        }
    }
}