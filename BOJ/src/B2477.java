/**
 * playtime = 01:16:32
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Field {
    int index;
    int dir;
    int length;

    public Field(int index, int dir, int length) {
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
    private static final ArrayList<Field> points = new ArrayList<>();

    public static void main(String[] args) {
        input();
        calculate();
    }

    private static void calculate() {
        Field longHeight = findLongHeight();
        Field longWidth = findLongWidth();

        ArrayList<Integer> list = new ArrayList<>();
        int longHeightIndex = longHeight.getIndex();
        int i1 = (longHeightIndex + 1) % 6;
        int i2 = (longHeightIndex + 5) % 6;
        list.add(i1);
        list.add(i2);

        int longWidthIndex = longWidth.getIndex();
        int i3 = (longWidthIndex + 1) % 6;
        int i4 = (longWidthIndex + 5) % 6;
        list.add(i3);
        list.add(i4);

        List<Integer> collect = points.stream()
                .filter(point -> !list.contains(point.getIndex()))
                .map(Field::getLength)
                .collect(Collectors.toList());

        System.out.println(k * ((longHeight.getLength() * longWidth.getLength()) - (collect.get(0) * collect.get(1))));
    }

    private static Field findLongHeight() {
        List<Field> fields = points.stream()
                .filter(point -> point.getDir() == 1 || point.getDir() == 2)
                .collect(Collectors.toList());

        return Collections.max(fields, Comparator.comparingInt(Field::getLength));
    }

    private static Field findLongWidth() {
        List<Field> fields = points.stream()
                .filter(point -> point.getDir() == 3 || point.getDir() == 4)
                .collect(Collectors.toList());

        return Collections.max(fields, Comparator.comparingInt(Field::getLength));
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        for (int i = 0; i < 6; i++) {
            int dir = sc.nextInt();
            int length = sc.nextInt();
            points.add(new Field(i, dir, length));
        }
    }
}
