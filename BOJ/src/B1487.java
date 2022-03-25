//playtime = 24:47

import java.util.Arrays;
import java.util.Scanner;

public class B1487 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int[][] price = new int[people][2];
        for (int i = 0; i < people; i++) {
            price[i][0] = sc.nextInt();
            price[i][1] = sc.nextInt();
        }
        Arrays.sort(price, (o1, o2) -> o1[0]- o2[0]);
        int sellPrice = 0;
        int maxBenefit = 0;
        int ans = 0;
        for (int i = 0; i < people; i++) {
            sellPrice = price[i][0];
            int maxTemp = 0;
            for (int j = 0; j < people; j++) {
                if (sellPrice > price[j][1] && sellPrice <= price[j][0]) {
                    maxTemp += sellPrice - price[j][1];
                }
            }
            if (maxBenefit < maxTemp) {
                maxBenefit = maxTemp;
                ans = sellPrice;
            }
        }
        System.out.println(ans);
    }
}
