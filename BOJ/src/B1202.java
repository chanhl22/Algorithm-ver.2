//playtime = 02:27:11

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Jewel1202 {
    int weight;
    int price;

    public Jewel1202(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class B1202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Jewel1202[] jewels = new Jewel1202[n];
        long[] bag = new long[k];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int p= sc.nextInt();
            jewels[i] = new Jewel1202(w, p);
        }
        for (int i = 0; i < k; i++) {
            bag[i] = sc.nextLong();
        }
        Arrays.sort(jewels, (o1, o2) -> {
            if(o1.weight - o2.weight == 0) {
                return o2.price - o1.price;
            } else {
                return o1.weight - o2.weight;
            }
        });
        Arrays.sort(bag);
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0, j = 0; i < k; i++) {
            while(j < n && jewels[j].weight <= bag[i]) {
                pq.add(jewels[j].price);
                j++;
            }
            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}

/**
 * TreeMap 으로 처리하면 시간초과 발생
 *
 import java.util.Comparator;
 import java.util.Map;
 import java.util.PriorityQueue;
 import java.util.Scanner;
 import java.util.TreeMap;

 public class B1202 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int k = sc.nextInt();

         TreeMap<Integer, Integer> jewel = new TreeMap<>(Comparator.reverseOrder()); //key = 가격, value = 무게
         for (int i = 0; i < n; i++) {
             int m = sc.nextInt();
             int v = sc.nextInt();
             jewel.put(v, m);
         }

         PriorityQueue<Integer> bag = new PriorityQueue<>(Comparator.reverseOrder());
         for (int i = 0; i < k; i++) {
             int c = sc.nextInt();
             bag.add(c);
         }

         long result = 0;

         while (!bag.isEmpty()) {
             while (!jewel.isEmpty()) {
                 Map.Entry<Integer, Integer> entry = jewel.pollFirstEntry();
                 if (bag.peek() >= entry.getValue()) {
                     result += (long) entry.getKey();
                     bag.remove();
                     break;
                 }
             }
         }

         System.out.println(result);

     }
 }
 */