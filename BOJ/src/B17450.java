/**
 * playtime = 10m 35s
 */

import java.util.Scanner;

public class B17450 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sPrice = sc.nextDouble();
        double sWeight = sc.nextDouble();
        double nPrice = sc.nextDouble();
        double nWeight = sc.nextDouble();
        double uPrice = sc.nextDouble();
        double uWeight = sc.nextDouble();

        double sSumWeight = sWeight * 10;
        double nSumWeight = nWeight * 10;
        double uSumWeight = uWeight * 10;

        double sSumPrice = sPrice * 10 >= 5000 ? sPrice * 10 - 500 : sPrice * 10;
        double nSumPrice = nPrice * 10 >= 5000 ? nPrice * 10 - 500 : nPrice * 10;
        double uSumPrice = uPrice * 10 >= 5000 ? uPrice * 10 - 500 : uPrice * 10;

        if (sSumWeight / sSumPrice > nSumWeight / nSumPrice && sSumWeight / sSumPrice > uSumWeight / uSumPrice) {
            System.out.println("S");
        }
        if (nSumWeight / nSumPrice > sSumWeight / sSumPrice && nSumWeight / nSumPrice > uSumWeight / uSumPrice) {
            System.out.println("N");
        }
        if (uSumWeight / uSumPrice > sSumWeight / sSumPrice && uSumWeight / uSumPrice > nSumWeight / nSumPrice) {
            System.out.println("U");
        }
    }
}
