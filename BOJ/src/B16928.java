import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dist = new int[101];
        int[] next = new int[101];
        //init
        for (int i = 1; i < 101; i++) {
            dist[i] = -1;
            next[i] = i;
        }
        //ladder
        while(n-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            next[x] = y;
        }
        //snake
        while(m-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            next[x] = y;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        while(!q.isEmpty()){
            int x = q.remove();
            for (int i = 1; i <= 6; i++) {
                int y = x + i;//A space can go to by rolling a dice
                if (y > 100) continue;
                y = next[y];//If the next value is changed by a snake or ladder (+empty place)
                if (dist[y] == -1){
                    dist[y] = dist[x] + 1;
                    q.add(y);
                }
            }
        }
        System.out.println(dist[100]);
    }
}


//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] dist = new int[101];
//        int[] next = new int[101];
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        for (int i=1; i<=100; i++) {
//            next[i] = -1;
//            dist[i] = -1;
//        }
//        for (int k=0; k<n+m; k++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            next[x] = y;
//        }
//        dist[1] = 0;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            for (int i=1; i<=6; i++) {
//                int y = x+i;
//                if (y > 100) continue;
//                if (next[y] != -1) {
//                    y = next[y];
//                }
//                if (dist[y] == -1) {
//                    dist[y] = dist[x] + 1;
//                    q.add(y);
//                }
//            }
//        }
//        System.out.println(dist[100]);
//    }
//}



//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] dist = new int[101];
//        int[] next = new int[101];
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        for (int i=1; i<=100; i++) {
//            next[i] = -1;
//            dist[i] = -1;
//        }
//        for (int k=0; k<n+m; k++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            next[x] = y;
//        }
//        dist[1] = 0;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            for (int i=1; i<=6; i++) {
//                int y = x+i;
//                if (y > 100) continue;
//                if (next[y] != -1 && dist[next[y]] == -1) {
//                    dist[next[y]] = dist[x] + 1;
//                    dist[y] = dist[x] + 1;
//                    q.add(next[y]);
//                } else {
//                    if (next[y] == -1 && dist[y] == -1) {
//                        dist[y] = dist[x] + 1;
//                        q.add(y);
//                    }
//                }
//            }
//        }
//        System.out.println(dist[100]);
//    }
//}

