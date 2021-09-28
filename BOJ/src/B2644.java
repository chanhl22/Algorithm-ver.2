import java.util.*;

public class B2644 {
    static int n;

    static int bfs(ArrayList<Integer>[] arr, int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        q.add(x);
        check[x] = true;
        dist[x] = 0;
        while (!q.isEmpty()) {
            int k = q.remove();
            for (Integer num : arr[k]) {
                if (check[num] == false) {
                    check[num] = true;
                    dist[num] = dist[k] + 1;
                    q.add(num);
                }
            }
        }
        return dist[y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int m = sc.nextInt();
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt() - 1;
            int second = sc.nextInt() - 1;
            arr[first].add(second);
            arr[second].add(first);
        }
        System.out.println(bfs(arr, x, y));
    }
}
