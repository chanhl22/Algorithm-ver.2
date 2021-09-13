import java.util.Scanner;

public class B2666 {
    static int m;
    static int[] move;

    static int go(int open1, int open2, int index, int sum) {
        if (index == m) {
            return sum;
        }
        int temp1 = go(move[index], open2, index + 1, sum + Math.abs(open1 - move[index]));
        int temp2 = go(open1, move[index], index + 1, sum + Math.abs(open2 - move[index]));
        return Math.min(temp1, temp2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int open1 = sc.nextInt();
        int open2 = sc.nextInt();
        m = sc.nextInt();
        move = new int[m];
        for (int i = 0; i < m; i++) {
            move[i] = sc.nextInt();
        }
        System.out.println(go(open1, open2, 0, 0));
    }
}
