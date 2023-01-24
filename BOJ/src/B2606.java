//playtime = 19:26
//풀이횟수 : 2

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pcCount = sc.nextInt();
        int pcPairCount = sc.nextInt();
        int[][] connect = new int[pcCount][pcCount];
        for (int i = 0; i < pcPairCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            connect[x][y] = connect[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] check = new boolean[pcCount];
        check[0] = true;

        int answer = 0;
        while(!q.isEmpty()) {
            int x = q.remove();
            for (int i = 0; i < pcCount; i++) {
                if (connect[x][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
