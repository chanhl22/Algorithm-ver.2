import java.util.Scanner;

class Node2 {
    int left;
    int right;
    int order;
    int depth;

    public Node2(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class B2250 {
    static Node2[] a = new Node2[10001]; //노드
    static int[] cnt = new int[10001]; //노드의 부모를 기록
    static int[] left = new int[10001]; //index: 깊이, value: 가장 왼쪽 order
    static int[] right = new int[10001]; //index: 깊이, value: 가장 오른쪽 order
    static int order = 0;

    static void inorder(int node, int depth) {
        if (node == -1) {
            return;
        }
        inorder(a[node].left, depth + 1);
        a[node].order = ++order;
        a[node].depth = depth;
        inorder(a[node].right, depth + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x] = new Node2(y, z);
            if (y != -1) cnt[y]++;
            if (z != -1) cnt[z]++;
        }
        //root 노드를 구함
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                root = i;
            }
        }
        //inorder로 모든 루트를 순회하면서 해당 노드의 순서(order)와 깊이(depth)를 구함
        inorder(root, 1);
        int maxdepth = 0;
        for (int i = 1; i <= n; i++) {
            int depth = a[i].depth;
            int order = a[i].order;
            if (left[depth] == 0) {
                left[depth] = order;
            } else {
                left[depth] = Math.min(left[depth], order);
            }
            right[depth] = Math.max(right[depth], order);
            maxdepth = Math.max(maxdepth, depth); //트리의 최종 깊이를 구함
        }
        int ans = 0;
        int ans_level = 0;
        for (int i = 1; i <= maxdepth; i++) {
            if (ans < right[i] - left[i] + 1){
                ans = right[i] - left[i] + 1;
                ans_level = i;
            }
        }
        System.out.println(ans_level + " " + ans);
    }
}