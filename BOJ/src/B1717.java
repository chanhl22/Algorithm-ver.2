/**
 * playtime = 53m 05s
 * 풀이횟수 = 2
 */

import java.io.*;
import java.util.*;

public class B1717 {
    static int[] parent;
    static int[] size; // 각 루트가 대표하는 집합의 크기 (union by size)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 원소 개수 (1..n)
        int m = Integer.parseInt(st.nextToken()); // 연산 개수

        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;  // 초기엔 자기 자신이 부모
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    // 루트 찾기 (경로 압축, 반복문 버전: 스택 오버플로우 예방)
    static int find(int x) {
        int root = x;
        while (root != parent[root]) {
            root = parent[root];
        }
        // 경로 압축
        while (x != root) {
            int p = parent[x];
            parent[x] = root;
            x = p;
        }
        return root;
    }

    // 크기 기준 합치기 (작은 트리를 큰 트리에 붙이기)
    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;

        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
        }
    }
}


//playtime = 15:03
//
//import java.util.Scanner;
//
//public class B1717 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] parent = new int[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            parent[i] = i;
//        }
//        for (int i = 0; i < m; i++) {
//            int zero_or_one = sc.nextInt();
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            if (zero_or_one == 0) {
//                unionParent(parent, a, b);
//            } else {
//                if (findParent(parent, a, b)) {
//                    System.out.println("YES");
//                } else {
//                    System.out.println("NO");
//                }
//            }
//        }
//    }
//
//    private static int getParent(int[] parent, int x) {
//        if (parent[x] == x) {
//            return x;
//        }
//        return parent[x] = getParent(parent, parent[x]);
//    }
//
//    private static void unionParent(int[] parent, int a, int b) {
//        a = getParent(parent, a);
//        b = getParent(parent, b);
//        if (a < b) parent[b] = a;
//        else parent[a] = b;
//    }
//
//    private static boolean findParent(int[] parent, int a, int b) {
//        a = getParent(parent, a);
//        b = getParent(parent, b);
//        if (a == b) {
//            return true;
//        }
//        return false;
//    }
//}
