//playtime = 29:37

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B12761 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i = 0; i < 8; i++) {
                int nx = 0;
                if (i == 0) {
                    nx = x + 1;
                } else if (i == 1) {
                    nx = x - 1;
                } else if (i == 2) {
                    nx = x + a;
                } else if (i == 3) {
                    nx = x + b;
                } else if (i == 4) {
                    nx = x - a;
                } else if (i == 5) {
                    nx = x - b;
                } else if (i == 6) {
                    nx = x * a;
                } else if (i == 7) {
                    nx = x * b;
                }
                if (nx > 0 && nx < 100001) {
                    if (visited[nx] == -1) {
                        q.add(nx);
                        visited[nx] = visited[x] + 1;
                    }
                }
            }
        }
        System.out.println(visited[m]);
    }
}