//playtime = 18:12

import java.util.Scanner;

public class B2828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = sc.nextInt();
        int[] apple = new int[count];
        for (int i = 0; i < count; i++) {
            apple[i] = sc.nextInt();
        }
        int time = 0;
        int start = 1;
        int end = start + m - 1;
        for (int i = 0; i < count; i++) {
            if (apple[i] >= start && apple[i] <= end) {
                continue;
            } else {
                while (apple[i] < start) {
                    start--;
                    end--;
                    time++;
                }
                while (apple[i] > end) {
                    start++;
                    end++;
                    time++;
                }
            }
        }
        System.out.println(time);
    }
}
