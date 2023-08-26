/**
 * playtime = 01:32:23
 */

import java.util.HashMap;
import java.util.Scanner;

public class B3100 {

    private static final char[][] strings = new char[6][9];

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            String input = sc.next();
            for (int j = 0; j < 9; j++) {
                strings[i][j] = input.charAt(j);
            }
        }
    }

    private static void solution() {
        int c = checkColumn();
        int r = checkRow();
        System.out.println(Math.min(r, c));
    }

    private static int checkColumn() {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map3 = new HashMap<>();

        updateColumnMap(map1, 0, 3);
        updateColumnMap(map2, 3, 6);
        updateColumnMap(map3, 6, 9);

        return findMin(map1, map2, map3);
    }

    private static void updateColumnMap(HashMap<Character, Integer> map, int start, int end) {
        for (int i = 0; i < 6; i++) {
            for (int j = start; j < end; j++) {
                char standard = strings[i][j];
                int count = 0;
                for (int k = 0; k < 6; k++) {
                    for (int l = start; l < end; l++) {
                        if (strings[k][l] != standard) {
                            count++;
                        }
                    }
                }
                if (!map.containsKey(standard)) {
                    map.put(standard, count);
                }
            }
        }
    }

    private static int checkRow() {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map3 = new HashMap<>();

        updateRowMap(map1, 0, 2);
        updateRowMap(map2, 2, 4);
        updateRowMap(map3, 4, 6);

        return findMin(map1, map2, map3);
    }

    private static void updateRowMap(HashMap<Character, Integer> map, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = 0; j < 9; j++) {
                char standard = strings[i][j];
                int count = 0;
                for (int k = start; k < end; k++) {
                    for (int l = 0; l < 9; l++) {
                        if (strings[k][l] != standard) {
                            count++;
                        }
                    }
                }
                if (!map.containsKey(standard)) {
                    map.put(standard, count);
                }
            }
        }
    }

    private static int findMin(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2, HashMap<Character, Integer> map3) {
        int count = -1;
        for (Character character1 : map1.keySet()) {
            for (Character character2 : map2.keySet()) {
                for (Character character3 : map3.keySet()) {
                    if (character1 != character2 && character2 != character3) {
                        if (count == -1 || count > map1.get(character1) + map2.get(character2) + map3.get(character3)) {
                            count = map1.get(character1) + map2.get(character2) + map3.get(character3);
                        }
                    }
                }
            }
        }
        return count == -1 ? 18 : count;
    }
}
