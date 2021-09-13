import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1963 {
    static int change(int num, int index, int digit) {
        if (index == 0 && digit == 0) {
            return -1;
        }
        //String s = Integer.toString(num);
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index, (char)(digit + '0'));
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //test case count
        boolean[] prime = new boolean[10001];
        // Sieve of Eratosthenes
        for (int i = 2; i < 10001; i++) {
            if (prime[i] == false) {
                for (int j = i * i; j < 10001; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (t-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int[] d = new int[10001]; //Record dits
            boolean[] c = new boolean[10001]; //Check visit
            for (int i = 0; i < 10001; i++) {
                d[i] = -1;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            d[s] = 0;
            c[s] = true;
            while (!q.isEmpty()) {
                int now = q.remove();
                for (int i = 0; i < 4; i++) { //index
                    for (int j = 0; j <= 9; j++) { //digit
                        int next = change(now, i, j);
                        if (next != -1) {
                            if (prime[next] == false && c[next] == false) {
                                q.add(next);
                                c[next] = true;
                                d[next] = d[now] + 1;
                            }
                        }
                    }
                }
            }
            if (d[e] == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(d[e]);
            }
        }
    }
}
