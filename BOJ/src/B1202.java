//playtime = 02:27:11

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Jewel {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class B1202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Jewel[] jewels = new Jewel[n];
        long[] bag = new long[k];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int p= sc.nextInt();
            jewels[i] = new Jewel(w, p);
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
