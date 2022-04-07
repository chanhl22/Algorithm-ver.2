//playtime = 51:08

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int l = sc.nextInt();
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            truck.add(sc.nextInt());
        }
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int time = 0;
        int bridgeWeight = 0;
        while (!truck.isEmpty()) {
            time++;
            bridgeWeight -= bridge.remove();
            if (bridgeWeight + truck.peek() <= l) {
                bridgeWeight += truck.peek();
                bridge.add(truck.remove());
            } else {
                bridge.add(0);
            }
        }
        System.out.println(time + w);
    }
}
