//playtime = 04:50

import java.util.Arrays;
import java.util.Scanner;

class Pair35 {
    int index;
    int age;
    String name;

    public Pair35(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }
}

public class B10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair35[] a = new Pair35[n];
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            a[i] = new Pair35(i, age, name);
        }
        Arrays.sort(a, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.index - o2.index;
            }else {
                return o1.age - o2.age;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i].age + " " + a[i].name);
        }
    }
}
