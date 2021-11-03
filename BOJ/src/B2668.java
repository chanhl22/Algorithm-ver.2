import java.util.*;

public class B2668 {
    static int n;
    static int[] a;
    static ArrayList<Integer> arr = new ArrayList<>();

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        q.add(num);
        check[num] = true;
        while(!q.isEmpty()) {
            int x = q.remove();
            if (check[a[x]] == false) {
                q.add(a[x]);
                check[a[x]] = true;
            } else {
                if (a[x] == num) {
                    arr.add(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        System.out.println(arr.size());
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
