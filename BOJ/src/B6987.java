import java.util.Scanner;

public class B6987 {
    static int[][] match;
    static int[] win;
    static int[] draw;
    static int[] lose;
    static boolean ok;

    static void go(int index) {
        if (ok) return;
        if (index == 15) {
            ok = true;
            return;
        }
        if (win[match[index][0]] > 0 && lose[match[index][1]] > 0) {
            win[match[index][0]]--;
            lose[match[index][1]]--;
            go(index + 1);
            win[match[index][0]]++;
            lose[match[index][1]]++;
        }
        if (draw[match[index][0]] > 0 && draw[match[index][1]] > 0) {
            draw[match[index][0]]--;
            draw[match[index][1]]--;
            go(index + 1);
            draw[match[index][0]]++;
            draw[match[index][1]]++;
        }
        if (lose[match[index][0]] > 0 && win[match[index][1]] > 0) {
            lose[match[index][0]]--;
            win[match[index][1]]--;
            go(index + 1);
            lose[match[index][0]]++;
            win[match[index][1]]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        match = new int[15][2];
        int index = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                match[index][0] = i;
                match[index][1] = j;
                index++;
            }
        }
        for (int t = 0; t < 4; t++) {
            win = new int[6];
            draw = new int[6];
            lose = new int[6];
            boolean check = true;
            for (int i = 0; i < 6; i++) {
                win[i] = sc.nextInt();
                draw[i] = sc.nextInt();
                lose[i] = sc.nextInt();
                if (win[i] + draw[i] + lose[i] != 5) {
                    check = false;
                }
            }
            ok = false;
            if (check == false) {
                ok = false;
            }else {
                go(0);
            }
            if (ok) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}