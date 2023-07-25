//playtime = 25:51

import java.util.Arrays;
import java.util.Scanner;

class Country8979 implements Comparable<Country8979> {
    int index;
    int gold;
    int silver;
    int bronze;

    public Country8979(int index, int gold, int silver, int bronze) {
        this.index = index;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Country8979 that) {
        if (this.gold < that.gold) {
            return 1;
        } else if (this.gold == that.gold) {
            if (this.silver < that.silver) {
                return 1;
            } else if (this.silver == that.silver) {
                if (this.bronze < that.bronze) {
                    return 1;
                } else if (this.bronze == that.bronze) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}

public class B8979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Country8979[] c = new Country8979[n];
        for (int i = 0; i < n; i++) {
            int index = sc.nextInt() - 1;
            int g = sc.nextInt();
            int s = sc.nextInt();
            int b = sc.nextInt();
            c[i] = new Country8979(index, g, s, b);
        }
        Arrays.sort(c);
        int[] rank = new int[n];
        Arrays.fill(rank, -1);
        for (int i = 0; i < n; i++) {
            if (rank[i] == -1) {
                rank[i] = i;
            } else {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (c[i].gold == c[j].gold && c[i].silver == c[j].silver && c[i].bronze == c[j].bronze) {
                    rank[j] = rank[i];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (c[i].index == k - 1) {
                ans = rank[i] + 1;
            }
        }
        System.out.println(ans);
    }
}
