/**
 * playtime = 01:16:32
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Field2477 {
    int index;
    int dir;
    int length;

    public Field2477(int index, int dir, int length) {
        this.index = index;
        this.dir = dir;
        this.length = length;
    }

    public int getIndex() {
        return index;
    }

    public int getDir() {
        return dir;
    }

    public int getLength() {
        return length;
    }
}

public class B2477 {
    private static int k;
    private static final ArrayList<Field2477> points = new ArrayList<>();

    public static void main(String[] args) {
        input();
        calculate();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        for (int i = 0; i < 6; i++) {
            int dir = sc.nextInt();
            int length = sc.nextInt();
            points.add(new Field2477(i, dir, length));
        }
    }

    private static void calculate() {
        Field2477 longHeight = findLongHeight();
        Field2477 longWidth = findLongWidth();

        List<Integer> legs = findShortLegs(longHeight, longWidth);

        System.out.println(k * ((longHeight.getLength() * longWidth.getLength()) - (legs.get(0) * legs.get(1))));
    }

    private static Field2477 findLongHeight() {
        List<Field2477> fields = points.stream()
                .filter(point -> point.getDir() == 1 || point.getDir() == 2)
                .collect(Collectors.toList());

        return Collections.max(fields, Comparator.comparingInt(Field2477::getLength));
    }

    private static Field2477 findLongWidth() {
        List<Field2477> fields = points.stream()
                .filter(point -> point.getDir() == 3 || point.getDir() == 4)
                .collect(Collectors.toList());

        return Collections.max(fields, Comparator.comparingInt(Field2477::getLength));
    }

    private static List<Integer> findShortLegs(Field2477 longHeight, Field2477 longWidth) {
        int longHeightIndex = longHeight.getIndex();
        int shortHeightIndex = (longHeightIndex + 3) % 6;

        int longWidthIndex = longWidth.getIndex();
        int shortWidthIndex = (longWidthIndex + 3) % 6;

        return points.stream()
                .filter(point -> point.getIndex() == shortHeightIndex || point.getIndex() == shortWidthIndex)
                .map(Field2477::getLength)
                .collect(Collectors.toList());
    }
}
