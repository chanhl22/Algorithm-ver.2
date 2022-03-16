//playtime = 01:10:42

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B1450 {
    static int n;
    static int c;
    static int[] w;
    static ArrayList<Integer> aSum;
    static ArrayList<Integer> bSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        w = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(temp[i]);
        }
        aSum = new ArrayList<>();
        bSum = new ArrayList<>();
        aBruteForce(0, 0);
        bBruteForce(n / 2, 0);
        Collections.sort(aSum);
        Collections.sort(bSum);
        bw.write(findAllCases(aSum, bSum) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int findAllCases(ArrayList<Integer> aSum, ArrayList<Integer> bSum) {
        int result = 0;
        int temp = bSum.size() - 1;
        for (int i = 0; i < aSum.size(); i++) {
            while (temp >= 0 && aSum.get(i) + bSum.get(temp) > c) {
                temp--;
            }
            result += temp + 1;
        }
        return result;
    }

    private static void aBruteForce(int index, int sum) {
        if (sum > c) {
            return;
        }
        if (index == n / 2) {
            aSum.add(sum);
            return;
        }
        aBruteForce(index + 1, sum + w[index]);
        aBruteForce(index + 1, sum);
    }

    private static void bBruteForce(int index, int sum) {
        if (sum > c) {
            return;
        }
        if (index == n) {
            bSum.add(sum);
            return;
        }
        bBruteForce(index + 1, sum + w[index]);
        bBruteForce(index + 1, sum);
    }
}
