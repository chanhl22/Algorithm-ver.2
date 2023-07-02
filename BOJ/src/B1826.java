/**
 * playtime = 03:38:06
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class GasStation implements Comparable<GasStation>{
    int dist;
    int gas;

    public GasStation(int dist, int gas) {
        this.dist = dist;
        this.gas = gas;
    }

    public int getDist() {
        return dist;
    }

    public int getGas() {
        return gas;
    }

    @Override
    public int compareTo(GasStation o) {
        return this.dist - o.dist;
    }
}

public class B1826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<GasStation> gasStations = new PriorityQueue<>(Comparator.comparingInt(GasStation::getDist));
        for (int i = 0; i < n; i++) {
            gasStations.add(new GasStation(sc.nextInt(), sc.nextInt()));
        }
        int l = sc.nextInt();
        int p = sc.nextInt();

        int answer = 0;

        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        while (l > p) {
            while (!gasStations.isEmpty() && gasStations.peek().getDist() <= p) {
                temp.add(gasStations.remove().getGas());
            }

            if (temp.isEmpty()) {
                System.out.println(-1);
                return;
            }

            p += temp.remove();
            answer++;
        }

        System.out.println(answer);
    }
}
