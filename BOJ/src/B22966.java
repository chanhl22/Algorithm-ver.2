import java.util.Scanner;

public class B22966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        int[] level = new int[n];
        int min = -1;
        int index = 0;
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
            level[i] = sc.nextInt();
            if (min == -1 || level[i] < min) {
                min = level[i];
                index = i;
            }
        }
        System.out.println(str[index]);
    }
}
