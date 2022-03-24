//playtime = 23:15

import java.util.Arrays;
import java.util.Scanner;

public class B1337 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int minAns = -1;
        for (int i = 0; i < n; i++) {
            int pushCount = 0;
            int index = i;
            for (int j = 0; j <= 4; j++) {
                if (index < n && array[i] + j == array[index]) {
                    index++;
                    continue;
                }
                pushCount++;
            }
            if (minAns == -1 || minAns > pushCount) {
                minAns = pushCount;
            }
        }
        System.out.println(minAns);
    }
}
