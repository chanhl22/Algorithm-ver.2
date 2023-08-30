/**
 * playtime = 01:43:40
 */

import java.util.ArrayList;
import java.util.Scanner;

class Pair22939 {
    int x;
    int y;
    boolean isVisit;

    public Pair22939(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair22939(int x, int y, boolean isVisit) {
        this.x = x;
        this.y = y;
        this.isVisit = isVisit;
    }
}

public class B22939 {
    private static int n;
    private static char[][] map;
    private static Pair22939 endPoint;
    private final static ArrayList<Pair22939> assassin = new ArrayList<>();
    private final static ArrayList<Pair22939> healer = new ArrayList<>();
    private final static ArrayList<Pair22939> mage = new ArrayList<>();
    private final static ArrayList<Pair22939> tanker = new ArrayList<>();


    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                char charAt = input.charAt(j);
                map[i][j] = charAt;
                if (charAt == 'H') {
                    assassin.add(0, new Pair22939(i, j, true));
                    healer.add(0, new Pair22939(i, j, true));
                    mage.add(0, new Pair22939(i, j, true));
                    tanker.add(0, new Pair22939(i, j, true));
                }
                if (charAt == 'J') {
                    assassin.add(new Pair22939(i, j));
                }
                if (charAt == 'C') {
                    healer.add(new Pair22939(i, j));
                }
                if (charAt == 'B') {
                    mage.add(new Pair22939(i, j));
                }
                if (charAt == 'W') {
                    tanker.add(new Pair22939(i, j));
                }
                if (charAt == '#') {
                    endPoint = new Pair22939(i, j);
                }
            }
        }
    }

    private static void solution() {
        int j = calculateDistance(assassin, 0, 0, 0);
        int c = calculateDistance(healer, 0, 0, 0);
        int b = calculateDistance(mage, 0, 0, 0);
        int w = calculateDistance(tanker, 0, 0, 0);

        int minimum = j;
        String result = "Assassin";
        if (c < minimum) {
            minimum = c;
            result = "Healer";
        }
        if (b < minimum) {
            minimum = b;
            result = "Mage";
        }
        if (w < minimum) {
            minimum = w;
            result = "Tanker";
        }

        System.out.println(result);
    }

    private static int calculateDistance(ArrayList<Pair22939> list, int index, int sum, int selectPoint) {
        if (index == list.size() - 1) {
            return sum + (Math.abs(list.get(selectPoint).x - endPoint.x) + Math.abs(list.get(selectPoint).y - endPoint.y));
        }

        int min = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isVisit) {
                continue;
            }
            list.get(i).isVisit = true;
            int result = calculateDistance(list, index + 1, sum + (Math.abs(list.get(selectPoint).x - list.get(i).x) + Math.abs(list.get(selectPoint).y - list.get(i).y)), i);
            list.get(i).isVisit = false;
            if (min == -1 || min > result) {
                min = result;
            }
        }
        return min;
    }
}
