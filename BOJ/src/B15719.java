/**
 * playtime = 42:38
 * 메모리 초과
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15719 {

    private static long n;
    private static long sum;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        n = Integer.parseInt(s1);
        String s2 = br.readLine();
        StringTokenizer st = new StringTokenizer(s2, " ");
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            sum += Integer.parseInt(s);
        }
    }

    private static void solution() {
        long total = (n * (n - 1)) / 2;
        System.out.println(sum - total);
    }
}
