package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result1 {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        String num = Integer.toString(n);
        BigInteger ans = new BigInteger(num);
//        BigInteger ans = BigInteger.valueOf(n);
        while (n-- > 1) {
            ans = ans.multiply(BigInteger.valueOf(n));
        }
        System.out.println(ans);
    }
}

public class H1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result1.extraLongFactorials(n);

        bufferedReader.close();
    }
}
