/**
 * playtime = 10:42
 */

import java.util.Scanner;

class Color1076 {
    String color;
    int value;
    long product;

    public Color1076(String color, int value, int product) {
        this.color = color;
        this.value = value;
        this.product = product;
    }
}

public class B1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Color1076[] colors = new Color1076[10];
        colors[0] = new Color1076("black", 0, 1);
        colors[1] = new Color1076("brown", 1, 10);
        colors[2] = new Color1076("red", 2, 100);
        colors[3] = new Color1076("orange", 3, 1000);
        colors[4] = new Color1076("yellow", 4, 10000);
        colors[5] = new Color1076("green", 5, 100000);
        colors[6] = new Color1076("blue", 6, 1000000);
        colors[7] = new Color1076("violet", 7, 10000000);
        colors[8] = new Color1076("grey", 8, 100000000);
        colors[9] = new Color1076("white", 9, 1000000000);

        String color1 = sc.next();
        String color2 = sc.next();
        String color3 = sc.next();
        String ret = "";
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            if (color1.equals(colors[i].color)) {
                ret += String.valueOf(colors[i].value);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (color2.equals(colors[i].color)) {
                ret += String.valueOf(colors[i].value);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (color3.equals(colors[i].color)) {
                ans = Long.parseLong(ret) * colors[i].product;
            }
        }
        System.out.println(ans);
    }
}
