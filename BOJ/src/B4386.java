//playtime = 01:48:10

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pair4386 {
    int num;
    double x;
    double y;

    public Pair4386(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge4386 {
    int start;
    int end;
    double dist;

    public Edge4386(int start, int end, double dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
}

public class B4386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //입력 받은 x,y 좌표를 정점으로
        Pair4386[] points = new Pair4386[n];
        for (int i = 0; i < n; i++) {
            int num = i;
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Pair4386(i, x, y);
        }

        //노드와 간선 정보
        ArrayList<Edge4386> set = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double dist = distance(points[i], points[j]);
                set.add(new Edge4386(points[i].num, points[j].num, dist));
            }
        }
        Collections.sort(set, (o1, o2) -> (int)(o1.dist - o2.dist));

        //사이클 테이블
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double sum = 0;

        //크루스칼 알고리즘
        for (int i = 0; i < set.size(); i++) {
            //동일한 부모를 가르키지 않는 경우, 즉 사이클이 발생하지 않을 때만 선택
            if (find(parent, set.get(i).start, set.get(i).end)) {
                sum += set.get(i).dist;
                unionParent(parent, set.get(i).start, set.get(i).end);
            }
        }
        System.out.println(sum);
    }

    //각 부모 노드를 합침
    private static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    //같은 부모를 가지는지 확인
    private static boolean find(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b) {
            return false;
        }
        return true;
    }

    private static int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    private static double distance(Pair4386 a, Pair4386 b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
