import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                int out = q.remove();
                sb.append(out);
                break;
            }
            for (int i = 1; i < k; i++) {
                int temp = q.remove();
                q.add(temp);
            }
            int out = q.remove();
            sb.append(out);
            sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
