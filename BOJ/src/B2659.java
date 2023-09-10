/**
 * playtime = 36:40
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B2659 {

    private static final ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            nums.add(sc.nextInt());
        }
    }

    private static void solution() {
        int minNum = findMinNum(nums.get(0), nums.get(1), nums.get(2), nums.get(3));
        findCount(minNum);
    }

    private static int findMinNum(int first, int second, int third, int fourth) {
        int min = -1;

        StringBuilder num1 = new StringBuilder();
        num1.append(first).append(second).append(third).append(fourth);
        min = Integer.parseInt(num1.toString());

        StringBuilder num2 = new StringBuilder();
        num2.append(second).append(third).append(fourth).append(first);
        if (min == -1 || min > Integer.parseInt(num2.toString())) {
            min = Integer.parseInt(num2.toString());
        }

        StringBuilder num3 = new StringBuilder();
        num3.append(third).append(fourth).append(first).append(second);
        if (min == -1 || min > Integer.parseInt(num3.toString())) {
            min = Integer.parseInt(num3.toString());
        }

        StringBuilder num4 = new StringBuilder();
        num4.append(fourth).append(first).append(second).append(third);
        if (min == -1 || min > Integer.parseInt(num4.toString())) {
            min = Integer.parseInt(num4.toString());
        }
        return min;
    }

    private static void findCount(int minNum) {
        int count = 1;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        StringBuilder num = new StringBuilder();
                        num.append(i);
                        num.append(j);
                        num.append(k);
                        num.append(l);
                        int findMinNum = findMinNum(i, j, k, l);
                        if (findMinNum == Integer.parseInt(num.toString())) {
                            if (minNum == Integer.parseInt(num.toString())) {
                                minNum = Integer.parseInt(num.toString());
                                System.out.println(count);
                            } else {
                                count++;
                            }
                        }
                    }
                }
            }
        }
    }
}
