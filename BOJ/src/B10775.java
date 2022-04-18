import java.util.Scanner;

public class B10775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        int P = sc.nextInt();
        boolean[] visited = new boolean[G + 1];
        int count = 0;
        for (int i = 0; i < P; i++) {
            boolean ok = false;
            int airplaneGate = sc.nextInt();
            if(airplaneGate > G) break;
            for (int j = airplaneGate; j >= 1; j--) {
                if (visited[j] == false) {
                    visited[j] = true;
                    ok = true;
                    count++;
                    break;
                }
            }
            if (ok == false) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(count);
    }
}